# myapp 실습프로젝트

## 1. 프로젝트 모듈 생성
- intellij로 프로젝트 생성 후 모듈 구성
  - intellij에서 프로젝트 생성
  - app-1 모듈 생성

## 2. 문자열 출력하기
- 자바에서 문자열 및 숫자를 출려갛는 방법
- 줄바꿈을 다루는 방법
- 이스케이프 문자를 다루는 방법
- 포맷 문자열을 출력하는 방법

```
[과제관리 시스템]

1. 과제
2. 게시글
3. 도움말
4. 종료
```

## 3. ANSI 이스케이프 코드를 사용하여 출력 문자열 꾸미기
- "[과제관리시스템]"을 볼드체, 빨강색으로 출력하는 방법"

## 4. 변수를 사용하여 데이터를 출력하기
- 변수를 사용하는 방법

## 5. 표준 입력 스트림 다루기
- 표준 입력 스트림(예:키보드)에서 값을 입력 받는 방법
- 조건문, 반복문을 사용하는 방법

```
[과제관리 시스템]

1. 과제
2. 게시글
3. 도움말
4. 종료
> 1
과제입니다.
> 2
게시글입니다.
> 3
도움말입니다.
> 4
종료합니다. <=== 프로그램 종료!
> menu
[과제관리 시스템]

1. 과제
2. 게시글
3. 도움말
4. 종료
```

## 6. 배열을 활용하여 메뉴 목록 다루기
- 배열 활용
- for 반목문 활용
- 작업할 내용
  - 메뉴를 배열에 저장한다.
  - 메뉴 목록을 출력할 때 배열에서 꺼내 출력한다.

## 7. 기능 단위로 명령문 묶기 : 메서드 사용법
- 메서드를 활용하여 중복 코드를 제거하는 방법
- static 메서드를 정의하고 호출하는 방법
- static 필드를 정의하고 사용하는 방법

## 8. 기능 단위로 명령문 묶기 : 메서드 사용법 II
- 조건문 사용법 익히기
- 메서드 사용법 익히기
- 작업할 내용
  - 각 메뉴에 대해 서브 메뉴를 출력하기

```
[과제관리 시스템]

1. 과제
2. 게시글
3. 도움말
4. 종료
메인> 1
[과제]
1. 등록
2. 조회
3. 변경
4. 삭제
0. 이전
메인/과제> 1
과제 등록입니다.
메인/과제> 2
과제 조회입니다.
메인/과제> 3
과제 변경입니다.
메인/과제> 4
과제 삭제입니다.
메인/과제> menu
[과제]
1. 등록
2. 조회
3. 변경
4. 삭제
0. 이전
메인/과제> 0
메인>
```

## 9. 메서드를 역할에 따라 분류하기 : 클래스 사용법
- 클래스 사용법
- 쌍방향 관계(bidirectional association)의 문제점과 해결 방법
- GRASP 패턴: Low Coupling, High Cohesion, Information Expert

## 10. 과제 및 게시글의 데이터에 대해 CRUL(create, retrieve/read, update, delete)를 구현하기
- 과제 및 게시글 데이터의 입력, 조회, 변경, 삭제하는 기능 구현하는 방법
  - 과제 입출력 항목: 과제명, 내용, 제출 마감일
  - 게시글 입출력 항목: 제목, 내용, 작성자, 작성일

## 11. 사용자 정의 데이터 타입 만들기
- 클래스 문법을 이용해서 과제 및 게시그 데이터를 닫을 타입을 정의하고 사용하는 방법

## 12. 배열을 이용하여 여러 개의 데이터를 다루기
- 배열을 이용하여 인스턴스 목록을 다루는 방법

## 13. 회원 메뉴를 추가하고 crud를 구현하기
- 메인 메뉴를 다음과 가팅 변경
```
[과제관리 시스템]

1. 과제
2. 게시글
3. 회원
4. 도움말
0. 종료
```

- 회원 데이터의 입력, 조회, 변경, 삭제하는 기능 구현하는 방법
  - 회원 입출력 항목: 이메일, 이름, 암호, 가입일

## 14. 스태틱 필드의 한계 확인
- BoardMenu 클래스를 복제하여 '가입인사 게시판'을 추가
- 클래스 코드 복제의 문제점 확인

## 15. 인스턴스 필드와 인스턴스 메서드 활용
- BoardMenu 클래스에 인스턴스 필드 및 메서드 적용, 생성자 적용
- 향후 확장성을 고려하여 AssignmentMenu, MemberMenu, MainMenu 클래스에도 인스턴스 필드와 인스턴스 메서드, 생성자를 적용
  - 그래서 실무에서는 대부분의 클래스가 인스턴스 필드와 인스턴스 메서드로 구성됨.
- 향후 확장성을 고려하여 Prompt 클래스에도 인스턴스 필드와 인스턴스 메서드를 적용
  - 생성자 도입: Scanner 사용할 입력 도구를 지정할 수 있게 함.
  - Prompt에 inputInt(), inputFloat(), inputBoolean() 메서드 추가
    - 사용자 입력한 문자열을 int, float, boolean으로 변경해주는 일을 함
- 의존 객체 주입의 개념과 구현
  - 생성자를 통해 Prompt 객체를 XxxMenu에 주입
- 리팩토링
  - ANSI Escape Sequence 값을 별도의 클래스로 분리
  - 역할에 따라 클래스를 패키지로 나눠서 분류

## 16. 인터페이스를 이용한 객체 사용 규칙 정의
- 인터페이스 문법으로 메뉴를 다루는 객체의 실행 규칙 정의
- 인터페이스에 정의한대로 메뉴를 다루는 객체를 구현
- 인터페이스에 정의한대로 메뉴를 다루는 객체를 실행

## 17. 인터페이스와 GoF의 Composite 패턴을 이용하여 메뉴를 구현하기
- GoF의 Composite 디자인 패턴 적용
  - 메뉴 간의 연결을 느슨하게 조정하기
  - 현황:
    - MainMenu와 나머지 Menu 객체들 사이에 coupling이 강결합되어 있음.
    - 메뉴 클래스를 추가하면 MainMenu클래스를 또 변경해야 함
  - 목표:
    - 메뉴를 추가하더라도 기존 클래스를 변경하지 않을 방법이 필요함.
  - 객체지향 설계 원칙 및 OOP rosua:
    - SOLID의 'OCP(Open/Closed Principle)' 준수
    - GRASP의 'Low Coupling' 책임 할당 원칙 준수

## 18. 인스턴스 목록 제어 기능을 별도의 클래스로 캡슐화: 재사용성 높임
- 핸들러 객체에서 수행하는 배열 다루는 일을 실제 배열을 가지고 있는 Repository객체로 이관하기
  - 현황:
    - Repository클래스의 배열 레퍼런스를 Handler에서 다루고 있음.
  - 목표:
    - 인스턴스를 다루는 기능을 다른 프로젝트에서도 재사용할 수 있게 만들고 싶음.
  - 객체지향 설계 원칙 및 OOP개념:
    - GRASP의 Information Expert 책임 할당 원칙 준수
    - GRASP의 High Cohesion책임 할당 원칙 준수
    - OOP의 Encapsulation(캡슐화)
  - 효과:
    - 배열을 다루는 코드를 별도의 객체로 분리하면 코드 재사용이 쉬워짐.
    - 객체의 역할을 전문화함으로써 코드를 관리하기가 쉬워짐.
    - 목록을 다루는 방식을 감추고 대신 외부에 공개된 도구(메서드)를 통해 목록을 사용하도록 유도하면, 목록을 다루는 방식을 변경하더라도 외부에 영향을 주지않음. 즉 기능을 변경하더라도 다른 클래스에 미치는 영향을 최소화시킬 수 있음.
## 19. 다형성을 이용하여 범용으로 사용할 수 있는 Repository클래스 만들기
- 목록 관리 범용 클래스 ObjectRepository정의
  - 다형성의 polymorphic variable 문법 활용
- 기존의 Repository클래스를 ObjectRepository로 대체

## 20. 제네릭을 사용하여 타입을 파라미터로 다루기
- ObjectRepository에 제네릭 적용하기
  - 범용 클래스를 특정 타입을 다루는 클래스로 제한할 수 있음.
  - 파라미터 값에 대해 특정 타입으로 한정할 수 있음.
  - 반환값의 타입을 형변환할 필요가 없음.
- T[] toArray(T[])메서드 추가하기
  - System.arraycopy() 메서드 사용하기
  - Arrays.copyOf() 메서드 사용하기

## 21. 자바 Collection API 사용하기 - ArrayList 적용
- 목록을 다루는 기존 Repository클래스를 자바 컬렉션 API로 교체

## 22. 접근 제어 modifier 및 setter, getter 도입하기
- 인스턴스 필드에 직접 접근하는 것을 막는 방법: private
- 인스턴스 필드에 값을 저장하고 꺼내는 방법: setter/getter

## 23. 상속(generalization)과 추상 클래스/추상 메서드, 접근 제어 활용하기
- MenuItem과 MenuGroup의 공통 코드를 추출하여 수퍼 클래스를 정의하기
- MenuHandler구현체의 공통 분모를 추출하여 수퍼 클래스 정의하기
- 수퍼 클래스를 추상 클래스로 정의하여 직접 사용을 막기
- 추상 메서드를 선언하여 서브 클래스에게 구현을 강요하기
- 서브 클래스가 의존 객체를 사용할 수 있도록 접근 범위를 protected로 설정하기

## 24. Date 클래스를 사용하여 날짜 데이터를 다루기
- java.util.Date/java.sql.Date 클래스를 활용하기

## 25. 예외 처리하기
- 예외가 발생했을 때 시스템을 멈추지 않게 하는 방법
- try ~catch ~finally 사용법

## 26. LinkedList 자료구조 구현하기
- 목록관리 범용클래스 LinkedList Wjddml
  - LinkedList 구동원리 이해 및 구현
  - 중첩클래스 활용: static 중첩 클래스 Node 정의
  - 제네릭 적용
  - List 구현체를 생성자를 통해 주입: DI(Dependency Injection) 적용
- List 객체 사용 규칙 정의
  - ArrayList, LinkedList에 List인터페이스 적용
- AbstractList 추상 클래스 적용
  - ArrayList, LinkedList에 AbstractList 추상클래스 적용
- MenuGroup에 적용
- Handler에 적용

## 27. Stack, Queue 자료구조 표현하기
- Stack과 Queue의 구동원리 이해 및 구현
- Stack 적용
  - MenuGroup에 Stack을 이용하여 Breadcrumb 구현
- GoF의 "Factory Method" 디자인패턴 적용
  - MenuGroup에 적용

## 28. Iterator 디자인 패턴을 활용하여 목록 조회 기능을 캡슐화하기
- GoF의 디자인 패턴 중 Iterator 패턴의 동작원리 이해 및 구현
- ArrayList, LinkedList, Stack, Queue에 적용
- 중첩 클래스 문법을 이용하여 Iterator 구현하기
  - static/non-static nested 클래스 문법을 호라용하는 방법
  - local/anonymous 클래스 문법을 활용하는 방법

## 29. 기존의 컬렉션 클래스 및 인터페이스를 자바 컬렉션 API로 교체하기
- java.util 패키지에서 제공하는 컬렉션 API로 교체

## 30. 리팩토링: App 클래스
- main() 메서드에 들어있는 코드를 기능에 따라 묶어 여러 메서드로 분리
- 공유하는 변수는 인스턴스 필드로 전환

## 31. File I/O API를 이용하여 데이터를 바이너리 형식으로 입출력하기
- FileInputStream/FileOutputStream 사용법
- 바이너리 형식으로 데이터를 입출력하는 방법

## 32. 상속을 이용하여 Primitive type과 String 출력 기능을 추가하기
- 상속을 이용하여 바이트 입출력 기능을 확장하기
  - DataInputStream = FileInputStream 클래스 + primitive type/String 값 읽기
  - DataOutputStream = FileOutputStream 클래스 + Primitive type/String 값 쓰기

## 33. 입출력 성능을 높이기 위해 버퍼 기능 추가하기
- 기존의 클래스에 버퍼 기능을 추가함.
  - BufferedDatainputStream = DataInputStream + 버퍼 기능
  - BufferedDataOutputStream = DataOutputStream + 버퍼 기능

## 34. 입출력 기능 확장에 상속 대신 Decorator 패턴을 적용하기
- 상속 vs Decorator 패턴(GoF)
  - 기존 코드를 손대지 않고 기능 확장하는 방법
  - 상속: 기능 확장 용이
  - Decorator: 기능 확장 및 기능 제거 용이
- BufferedDataInputStream 분해
  - BufferedInputStream, DataInputStream, FileInputStream, FileInputStream
- BufferedDataOutputStream 분해
  - BufferedOutputStream, DataOutputStream, FileOutputStream
- Java I/O Stream API로 대체하기

## 35. 인스턴스를 통째로 입출력하기(객체 직렬화)
- ObjectInputStream/ObjectOutputStrem 사용법
  - java.io.Serializable 인터페이스 사용법
  - transient modifier 사용법

## 36. 리팩토링 - 중복 코드 정리
- 데이터 읽고 쓰는 중복 코드 정리
- serialVersionUID 스태틱 필드 사용하기

## 37. character I/O stream API를 사용하여 CSV 텍스트 형식으로 입출력하기
- CSV 형식으로 데이터를 읽고 쓰는 법
- FileReader/FileWriter 사용법
- GRASP의 Information Expert 패턴 적용
  - toCsvString() 메서드 정의
  - createFromCsv() 메서드 정의
- GoF의 Factory Method 패턴 적용
  - createFromCsv() 메서드 정의
- Reflection API 사용
  - createFromCsv() 메서드 정보