# Windows / PowerShell

## Backend

Install Java 21+ and Maven, then:

```powershell
cd backend
mvn test
mvn spring-boot:run
```

## Frontend

```powershell
cd frontend
npm install
npm run dev
```

The backend intentionally starts with H2, so the demo requires no database setup.

For PostgreSQL/Docker, use:

```powershell
docker compose up --build
```
