# Setup

1. Build gradle `.\gradlew build`
2. Run npm install
```
cd feature-toggle-frontend
npm i
```
3. Run Projects

Java: 
```
.\gradlew feature-toggle-backend:bootRun
```
Angular:
```
cd feature-toggle-frontend
npm run start
```

(Or just with your IDE)

4. Open `http://localhost:4200/`

5. With `http://localhost:8080/h2-console/` you can view your DB
<br>
<br>
JDBC URL: jdbc:h2:file:./feature-toggle-backend/build/h2-database/feature-toggle
<br>
Username: sa
<br>
<br>
Leave the password blank