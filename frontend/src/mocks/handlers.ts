import { rest } from 'msw';

import { Schedule } from '@/@types';
import { CategoryType } from '@/@types/category';

import categoryApi from '@/api/category';
import profileApi from '@/api/profile';
import scheduleApi from '@/api/schedule';

import { categoryDB, profileDB, scheduleDB } from './data';

const handlers = [
  rest.get(categoryApi.endpoint, (req, res, ctx) => {
    const page = parseInt(req.url.searchParams.get('page') as string);
    const size = parseInt(req.url.searchParams.get('size') as string);
    const slicedCategories = categoryDB.data.slice((page - 1) * size, (page - 1) * size + size);

    return res(
      ctx.status(200),
      ctx.json({
        totalCount: 18,
        page,
        data: slicedCategories,
      })
    );
  }),

  rest.post<Pick<CategoryType, 'name'>>(categoryApi.endpoint, (req, res, ctx) => {
    categoryDB.data.push({
      id: categoryDB.data.length + 1,
      createdAt: new Date().toISOString().slice(0, -5),
      ...req.body,
    });

    return res(ctx.status(201));
  }),

  rest.get(profileApi.endpoint, (req, res, ctx) => {
    return res(ctx.status(200), ctx.json(profileDB));
  }),

  rest.get(scheduleApi.endpoint, (req, res, ctx) => {
    return res(ctx.status(200), ctx.json({ schedules: scheduleDB }));
  }),

  rest.post<Omit<Schedule, 'id'>>(scheduleApi.endpoint, (req, res, ctx) => {
    scheduleDB.push({ id: scheduleDB.length + 1, ...req.body });

    return res(ctx.status(201));
  }),
];

export { handlers };
