Back-end 요구사항
- 고정 확장자 - 고정 확장자는 차단을 자주하는 확장자 리스트
    - 체크, 미체크 여부를 DB에 저장
- 커스텀 확장자
  - 최대 20자리
  - 한 유저당 최대 200개 저장 가능
  - Read, Create, Delete 기능

API 설계서
- 고정 확장자
  - `GET /api/v1/fixed-extensions`
    - 고정 확장자 리스트 조회
  - `POST /api/v1/fixed-extensions/{extension}`
    - 고정 확장자 추가
  - `DELETE /api/v1/fixed-extensions/{extension}`
    - 고정 확장자 삭제
- 커스텀 확장자
  - `GET /api/v1/custom-extensions`
    - 커스텀 확장자 리스트 조회
  - `POST /api/v1/custom-extensions`
    - 커스텀 확장자 추가
  - `DELETE /api/v1/custom-extensions/{id}`
    - 커스텀 확장자 삭제
  - `GET /api/v1/custom-extensions/{id}`
    - 커스텀 확장자 조회

Front-end 요구사항