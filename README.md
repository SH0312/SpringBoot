##SpringBoot 초기 설정

##System 정보
	-java 
	jdk_1.8_221
	(JAVA 낮은버전 사용 시 정상 작동안 됨.)
	-spring
	2.1.6
	-server
	내장 톰켓 
	-port
	80

###mysql 연동
	mysql 정보 입력 : application.properties 
	url : localhost/mysql
	
###JSP 페이지 연동
	url : localhost/
	
	
###아래 디펜던시 사용시 페이지가 정상작동하지 않음.
	-view를 타지 않는 @RestController는 정상작동하지만, 
	@Controller를 사용해도 해당 메소드는 실행되지만 view는 찻지 못함(500 error)
	
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-thymeleaf</artifactId>
	</dependency>

	
