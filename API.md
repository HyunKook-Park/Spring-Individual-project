#API.md

# Step 1. (API 명세서)

| API 명    | Method | URL                | Request | Response |    상태코드    | 
|----------|--------|--------------------|---------|:--------:|:----------:|
| 일정 등록    | POST   | /api/schedule      | body    |   등록정보   | 200: 정상 등록 |
| 일정 조회    | GET    | /api/schedule/{id} | path    | 단건 응답 정보 | 200: 정상 조회 |
| 일정 목록 조회 | GET    | /api/schedule      | param   | 다건 응답 정보 | 200: 정상 조회 |
| 일정 수정    | PUT    | /api/schedule/{id} | body    |  수정 정보   | 200: 정상 수정 |
| 일정 삭제    | DELETE | /api/schedule/{id} | path    |    -     | 200: 정상 삭제 |


# Step 2. (ERD 작성)
일정 등록 Table: 일정 식별 ID, 할일, 담당자명, 비밀번호, 작성/수정일

작성/수정일 조건: YYYY/MM/DD HH.MM.SS, 생성 시 날짜 자동 추가, 최초 생성 시 작성일과 수정일은 동일 

일정 식별 ID 조건: 자동 생성

