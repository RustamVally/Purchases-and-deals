CREATE TABLE car
(
    id           BIGSERIAL PRIMARY KEY,
    name         TEXT      NOT NULL,
    price        INT CHECK ( price >= 1 ),
    model        TEXT      NOT NULL,
    manufacturer TEXT      NOT NULL,
    removed      BOOL      NOT NULL DEFAULT FALSE,
    created      timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE deals
(
    id      BIGSERIAL PRIMARY KEY,
    created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE deals_positions
(
    id      BIGSERIAL PRIMARY KEY,
    deal_id BIGINT NOT NULL REFERENCES deals,
    car_id  BIGINT NOT NULL REFERENCES car,
    name    TEXT   NOT NULL,
    price   INT CHECK ( price >= 1 )
);