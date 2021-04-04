## 개발환경
- spring boot(2.4.4)
- java(11)
- maven(3.6.3)
- mybatis(2.1.6)
- mysql


## 사용방법
1. application.properties 파일에 datasource 설정
2. application.properties 파일에 spring.datasource.initialization-mode를 always로 변경(shcema.sql 파일 실행)
3. StoreManagerServiceTest 테스트코드 실행