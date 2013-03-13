CREATE TABLE company ( 
                        compID int4 primary key,
                        name  varchar(50) NOT NULL UNIQUE,
                        address varchar(50) NOT NULL,
                        city varchar(50) NOT NULL,
                        state varchar(50) NOT NULL,
                        zip  varchar(50) NOT NULL);


CREATE TABLE form_status (
                           filename varchar(50),
                           compID  int4,
                           form_dttm date,
                           status int4,
                           error_msg varchar(100),  
                           process_dttm date,
                           primary key (filename, process_dttm),
                           foreign key (compID) references company on delete cascade);

CREATE TABLE forms (
                    form_id varchar(50) primary key)



CREATE TABLE compensation ( 
                        compID int4,
                        year  date,
                        name varchar(100) NOT NULL,
                        position varchar(100) NOT NULL,
                        salary int4 NOT NULL,
                        bonus int4,
                        other int4,
                        stock_options int4,
                        all_other_compensation int4,
                        primary key (compID, year, position),
                        foreign key (compID) references company on delete cascade);


CREATE TABLE pattern_group ( 
                          group_seq int4 primary key,
                          form_id varchar(50) NOT NULL,
                          attempts int4 default (0),
                          success int4 default (0),
                          foreign key (form_id) references forms on delete cascade);

CREATE TABLE pattern ( 
                          pattern_seq int4,
                          group_seq  int4,
                          pattern varchar(50) NOT NULL,
                          primary key (pattern_seq, group_seq),
                          foreign key (group_seq) references pattern_group on delete cascade);
