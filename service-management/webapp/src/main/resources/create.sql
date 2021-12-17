CREATE TABLE MONACO_SERVICE (
                ID INT NOT NULL,
                TAG VARCHAR(5) NOT NULL,
                `ACTION` VARCHAR(10) NOT NULL,
                CONSTRAINT ID PRIMARY KEY (ID)
            );


INSERT INTO MONACO_SERVICE (ID,TAG,`ACTION`) VALUES
    (22,'tag22','ACTIVE'),
    (23,'tag23','ACTIVE');