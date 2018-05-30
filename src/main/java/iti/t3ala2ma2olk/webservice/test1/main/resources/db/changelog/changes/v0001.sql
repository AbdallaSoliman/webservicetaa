create table "user" (
  id varchar(255) ,
  name varchar(50) ,
  primary key (id)
);

create table exam (
  id BIGINT ,
  title varchar(50) ,
  description varchar(512) ,
  primary key (id)
);

-- create table questions (
--   id BIGINT ,
--   exam_id BIGINT  references exam (id),
--   question_order BIGINT ,
--   description text ,
--   primary key (id)
-- );
-- 
-- create table alternative (
--   id BIGINT ,
--   questions_id BIGINT  references questions (id),
--   alternative_order bigint ,
--   description text ,
--   correct boolean ,
--   primary key (id)
-- );

create table attempt (
  id BIGINT ,
  user_id varchar(255)  references "user" (id),
--   alternative_id BIGINT  references alternative (id),
  correct boolean ,
  date timestamp without time zone ,
  primary key (id)
);