create sequence public.assunto_id_seq increment 1 minvalue 1 maxvalue 9223372036854775807 start 1 cache 1;
alter table public.assunto_id_seq  owner to postgres;

create sequence public.protocolo_id_seq increment 1 minvalue 1 maxvalue 9223372036854775807 start 1 cache 1;
alter table public.protocolo_id_seq  owner to postgres;

create sequence public.evento_id_seq increment 1 minvalue 1 maxvalue 9223372036854775807 start 1 cache 1;
alter table public.evento_id_seq  owner to postgres;

create sequence public.interessado_id_seq increment 1 minvalue 1 maxvalue 9223372036854775807 start 1 cache 1;
alter table public.interessado_id_seq  owner to postgres;

create table public.assunto (
    id  bigint not null default nextval('assunto_id_seq'::regclass),
    titulo  character varying(150) not null,
    prefixo_protocolo  character varying(3) not null,
    constraint assunto_pkey primary key (id)
) with (oids=false);
alter table public.assunto owner to postgres;

create table public.interessado (
    id  bigint not null default nextval('interessado_id_seq'::regclass),
    nome character varying(255) not null,
    cpf_cnpj character varying(14) not null,
    constraint interessado_pkey primary key (id)
) with (oids=false);
alter table public.interessado owner to postgres;

create table public.protocolo (
    id  bigint not null default nextval('protocolo_id_seq'::regclass),
    titulo  character varying(80) not null,
    descricao  character varying(4096) not null,
    assunto bigint not null,
    situacao  character varying(25),
    interessado bigint,
    constraint protocolo_pkey primary key (id),
    constraint fk_protocolo_assunto foreign key (assunto)
        references public.assunto (id) match simple
        on update no action on delete no action,
    constraint fk_protocolo_interessado foreign key (interessado)
        references public.interessado (id) match simple
        on update no action on delete no action
) with (oids=false);
alter table public.protocolo owner to postgres;

create table public.evento (
  id  bigint not null default nextval('evento_id_seq'::regclass),
  data_hora  timestamp without time zone not null,
  tipo_evento  character varying(35) not null,
  protocolo bigint,
  constraint evento_pkey primary key (id),
  constraint fk_evento_protocolo foreign key (protocolo)
    references public.protocolo (id) match simple
    on update no action on delete no action
) with (oids=false);
alter table public.evento owner to postgres;

create table public.evento_arquivamento (
  id bigint not null,
  motivo character varying(200) not null,
  observacoes character varying(300) ,
  constraint evento_arquivamento_pkey primary key (id)
) with (oids=false);
alter table public.evento_arquivamento owner to postgres;

create table public.evento_desarquivamento (
  id  bigint not null,
  constraint evento_desarquivamento_pkey primary key (id)
) with (oids=false);
alter table public.evento_desarquivamento owner to postgres;
