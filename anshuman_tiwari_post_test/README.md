# Campus Recruitment Training — Phase 2 · Post-Assessment

**Author:** Anshuman Tiwari

This repository contains my solutions to the Phase-2 Post-Assessment test.
Answers are organized by **section** and **question number** under
`src/main/java/com/test`.

## Layout

| Section | Questions | Location |
|---------|-----------|----------|
| A — Spring Boot & Request Lifecycle | Q1–Q6  | `src/main/java/com/test/sectionA/qN` |
| B — JPA, SQL & Data Layer           | Q7–Q11 | `src/main/java/com/test/sectionB/qN` |
| C — Microservices & System Design   | Q12–Q16| `src/main/java/com/test/sectionC/qN` |
| D — Testing & Docker                | Q17–Q18| `src/main/java/com/test/sectionD/qN` |
| E — Frontend Integration (Bonus)    | Q21–Q22| `src/main/java/com/test/sectionE/qN` |

### Files that live outside the section folders (as required by the question)
- **Q19** Dockerfile → project root: `Dockerfile`
- **Q20** docker-compose → `src/main/resources/docker-compose.yml`
- **Q17** test class → `src/test/java/com/test/sectionD/q17/ProductServiceTest.java`
- Main Spring Boot entry point → `src/main/java/com/test/MainApplication.java`

## Building & running

```bash
mvn clean package          # produces target/app.jar
mvn test                   # runs the Q17 unit test
java -jar target/app.jar   # runs the app on port 8080

# Docker (Q19 / Q20)
docker build -t myapp:latest .
docker run -p 8080:8080 myapp:latest
docker compose -f src/main/resources/docker-compose.yml up
```

> Note: until `mvn` (or IntelliJ's Maven import) downloads the dependencies
> declared in `pom.xml`, the IDE will show "cannot resolve `org.springframework` /
> `jakarta`" warnings. These disappear once dependencies are resolved.
