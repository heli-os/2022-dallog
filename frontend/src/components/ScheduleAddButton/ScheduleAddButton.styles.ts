// eslint-disable-next-line import/named
import { css, Theme } from '@emotion/react';

const scheduleAddButton = ({ colors }: Theme) => css`
  width: 36px;
  height: 36px;

  border-radius: 50%;

  background: ${colors.yellow_500};

  font-size: 20px;
  line-height: 20px;
  font-weight: 700;
  color: ${colors.white};

  &:hover {
    opacity: 0.7;
  }
`;

export { scheduleAddButton };
