 CREATE  VIEW  activity_view  AS
SELECT  a.*, l.name AS lead_name
 FROM leads l JOIN activities a
    ON l.id = a.lead_id;
