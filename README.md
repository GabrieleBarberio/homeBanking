Progetto di prova in java per un applicazione che simuli il comportamento (dummy) di un home banking.
Teconologie, linguaggi e tools utilizzati: 
- SQL
- JAVA
- Servizi REST
- JPA + Hibernate
- EJB
- DataSource
- Deploy su WildFly 24+

Nello schema dedicato bisogna creare un trigger che gestisca il movimento dei soldi tra i vari conti e effettui le ricariche sul conto, ecco lo script:

```
DELIMITER $$

CREATE TRIGGER checkop BEFORE INSERT ON operazioni
FOR EACH ROW
BEGIN
    DECLARE new_saldo_residuo DOUBLE;
    IF NEW.emittente != NEW.ricevente THEN
        SELECT saldo_residuo INTO new_saldo_residuo FROM conto WHERE id_conto = NEW.emittente;
        IF new_saldo_residuo - NEW.ammonto < 0 THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'fondi insufficienti per effettuare l`operazione';
        ELSE
            UPDATE conto
            SET saldo_residuo = saldo_residuo + NEW.ammonto
            WHERE id_conto = NEW.ricevente;

            UPDATE conto
            SET saldo_residuo = saldo_residuo - NEW.ammonto
            WHERE id_conto = NEW.emittente;
        END IF;
    ELSE
        IF NEW.emittente = NEW.ricevente THEN
            UPDATE conto
            SET saldo_residuo = saldo_residuo + NEW.ammonto
            WHERE id_conto = NEW.ricevente;
        END IF;
    END IF;
END$$

DELIMITER ;
```
