--db creation
-- Table: public.categories

-- DROP TABLE IF EXISTS public.categories;

CREATE TABLE IF NOT EXISTS public.categories
(
    id integer NOT NULL DEFAULT nextval('categories_id_seq'::regclass),
    name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT categories_pkey PRIMARY KEY (id),
    CONSTRAINT categories_name_key UNIQUE (name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.categories
    OWNER to postgres;
    
-- Table: public.retailers

-- DROP TABLE IF EXISTS public.retailers;

CREATE TABLE IF NOT EXISTS public.retailers
(
    id integer NOT NULL DEFAULT nextval('retailers_id_seq'::regclass),
    name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT retailers_pkey PRIMARY KEY (id),
    CONSTRAINT name UNIQUE (name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.retailers
    OWNER to postgres;
    
-- Table: public.manufacturers

-- DROP TABLE IF EXISTS public.manufacturers;

CREATE TABLE IF NOT EXISTS public.manufacturers
(
    id integer NOT NULL DEFAULT nextval('manufacturers_id_seq'::regclass),
    name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT manufacturers_pkey PRIMARY KEY (id),
    CONSTRAINT manufacturers_name_key UNIQUE (name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.manufacturers
    OWNER to postgres;
    
-- Table: public.products

-- DROP TABLE IF EXISTS public.products;

CREATE TABLE IF NOT EXISTS public.products
(
    id integer NOT NULL DEFAULT nextval('products_id_seq'::regclass),
    name text COLLATE pg_catalog."default" NOT NULL,
    manufacturer_id integer,
    category_id integer,
    weight_in_grams integer,
    CONSTRAINT products_pkey PRIMARY KEY (id),
    CONSTRAINT products_name_key UNIQUE (name),
    CONSTRAINT category FOREIGN KEY (category_id)
        REFERENCES public.categories (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT manufacturer FOREIGN KEY (manufacturer_id)
        REFERENCES public.manufacturers (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.products
    OWNER to postgres;
    
    
-- Table: public.purchases

-- DROP TABLE IF EXISTS public.purchases;

CREATE TABLE IF NOT EXISTS public.purchases
(
    id integer NOT NULL DEFAULT nextval('purchases_id_seq'::regclass),
    product_id integer NOT NULL,
    date date NOT NULL,
    retailer_id integer NOT NULL,
    price integer NOT NULL,
    CONSTRAINT purchases_pkey PRIMARY KEY (id),
    CONSTRAINT purchases_product_id_fkey FOREIGN KEY (product_id)
        REFERENCES public.products (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT purchases_retailer_id_fkey FOREIGN KEY (retailer_id)
        REFERENCES public.retailers (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.purchases
    OWNER to postgres;