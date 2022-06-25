-- Table: public.teams

DROP TABLE IF EXISTS public.teams;

DROP SEQUENCE IF EXISTS public.teams_id_seq;



CREATE SEQUENCE IF NOT EXISTS public.teams_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE IF NOT EXISTS public.teams
(
    id bigint NOT NULL DEFAULT nextval('teams_id_seq'::regclass),
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    date_created timestamp without time zone NOT NULL DEFAULT now(),
    date_modified timestamp without time zone NOT NULL DEFAULT now(),
    CONSTRAINT teams_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.teams
    OWNER to postgres;
    
    
INSERT INTO public.teams(name)VALUES ('FC Chelsea');
INSERT INTO public.teams(name)VALUES ('Brighton & Hove Albion FC');
INSERT INTO public.teams(name)VALUES ('Aston Villa FC');
INSERT INTO public.teams(name)VALUES ('Leeds United');
INSERT INTO public.teams(name)VALUES ('Southampton FC');
INSERT INTO public.teams(name)VALUES ('Manchester United FC');
INSERT INTO public.teams(name)VALUES ('Chelsea FC'); 
INSERT INTO public.teams(name)VALUES ('West Ham United FC');



-- Table: public.matches

DROP TABLE IF EXISTS public.matches;

DROP SEQUENCE IF EXISTS public.matches_id_seq;

CREATE SEQUENCE IF NOT EXISTS public.matches_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE IF NOT EXISTS public.matches
(
    id bigint NOT NULL DEFAULT nextval('matches_id_seq'::regclass),
    home_team_id bigint NOT NULL,
    home_team_score smallint,
    away_team_id bigint NOT NULL,
    away_team_score smallint,
    start_date timestamp without time zone NOT NULL,
    date_created timestamp without time zone NOT NULL DEFAULT now(),
    date_modified timestamp without time zone NOT NULL DEFAULT now(),
    CONSTRAINT matches_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.matches
    OWNER to postgres;
    
    
    
INSERT INTO public.matches(home_team_id, home_team_score, away_team_id, away_team_score, start_date)VALUES (1, 2, 2, 0, '2022-03-22 10:00:00');
INSERT INTO public.matches(home_team_id, home_team_score, away_team_id, away_team_score, start_date)VALUES (3, 0, 4, 1, '2022-03-23 10:00:00');
INSERT INTO public.matches(home_team_id, home_team_score, away_team_id, away_team_score, start_date)VALUES (5, 2, 6, 0, '2022-03-22 05:00:00');
INSERT INTO public.matches(home_team_id, home_team_score, away_team_id, away_team_score, start_date)VALUES (7, 2, 3, 0, '2022-03-22 11:00:00');
INSERT INTO public.matches(home_team_id, home_team_score, away_team_id, away_team_score, start_date)VALUES (5, 2, 3, 0, '2022-03-25 10:00:00');
INSERT INTO public.matches(home_team_id, away_team_id, start_date)VALUES (5, 3, '2022-07-29 11:00:00');
INSERT INTO public.matches(home_team_id, home_team_score, away_team_id, away_team_score, start_date)VALUES (2, 2, 8, 0, '2022-03-25 11:00:00');
INSERT INTO public.matches(home_team_id, home_team_score, away_team_id, away_team_score, start_date)VALUES (5, 2, 6, 2, '2022-04-24 05:00:00');