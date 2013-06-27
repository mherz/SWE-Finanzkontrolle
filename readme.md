Online Finanzkontrolle

Eingesetzte Frameworks:

UI-Framework/Rich Internet Application Framework: 	Vaadin
Persitence: 						Hibernate
Dependency Injection: 					Spring

Architektur: Model-View-Presenter

Umgebung:
OFK benötigt einen Java-Servlet Container(Tomcat bevorzugt) und eine MySQL Datenbank zur Ausführung. 
Ist eine entsprechende Datenbank vorhanden (für DB Connection infos siehe applicationContext.xml) legt Hibernate die Tabellen automatisch an, wenn der Eintrag
<prop key="hibernate.hbm2ddl.auto">update</prop> in der applicationContext.xml durch <prop key="hibernate.hbm2ddl.auto">create</prop> ersetzt wird.
Anschließend sollte der Eintrag wieder zurückgesetzt werden, da Hibernat ansonsten bei jedem Deployen die Tabellen löscht und neu anlegt.


DBTestData.sql enthält Testdaten für die Datenbank.
