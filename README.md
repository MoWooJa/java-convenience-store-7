### 출력

- [ ]  재고 출력

```java
안녕하세요. W편의점입니다.
현재 보유하고 있는 상품입니다.

- 콜라 1,000원 10개 탄산2+1
- 콜라 1,000원 10개
- 사이다 1,000원 8개 탄산2+1
- 사이다 1,000원 7개
- 오렌지주스 1,800원 9개 MD추천상품
- 오렌지주스 1,800원 재고 없음
- 탄산수 1,200원 5개 탄산2+1
- 탄산수 1,200원 재고 없음
- 물 500원 10개
- 비타민워터 1,500원 6개
- 감자칩 1,500원 5개 반짝할인
- 감자칩 1,500원 5개
- 초코바 1,200원 5개 MD추천상품
- 초코바 1,200원 5개
- 에너지바 2,000원 5개
- 정식도시락 6,400원 8개
- 컵라면 1,700원 1개 MD추천상품
- 컵라면 1,700원 10개
```

### 재고 관리

- [ ]  상품을 구매 완료하면 재고를 차감한다
- [ ]  사용자가 상품 구매를 희망할 때, 재고를 고려해서 상품을 구매할 수 있는지 확인한다
- [ ]  프로모션 재고와 일반재고가 나누어진다
- [ ]  프로모션 기간 중이라면 프로모션 재고를 먼저 차감하고, 일반재고를 차감한다

### 프로모션 할인

- [ ]  오늘이 프로모션 기간이면 할인을 적용한다
- [ ]  buy x get 1 free 형태로 진행한다
- [ ]  동일상품에 여러 프로모션이 적용X
- [ ]  프로모션 혜택은 프로모션 재고 내에서만 적용 가능하다
- [ ]  받지 못한  프로모션 할인 물어보기
	- N → 해당 재고만큼 빼서 계산

```java
현재 콜라 4개는 프로모션 할인이 적용되지 않습니다. 그래도 구매하시겠습니까? (Y/N)
Y
```

- [ ]  놓친 혜택 받을 것인지 물어보기

```
현재 오렌지주스은(는) 1개를 무료로 더 받을 수 있습니다. 추가하시겠습니까? (Y/N)
Y
```

### 멤버십 할인

- [ ]  멤버십 회원은 프로모션 미적용 금액의 30%를 할인
	- 프로모션 적용 후 남은 금액에 대해 멤버십 할인을 적용한다
- [ ]  최대 한도 8000

### **영수증 출력**

- 영수증은 고객의 구매 내역과 할인을 요약하여 출력한다.
- 영수증 항목은 아래와 같다.
	- 구매 상품 내역: 구매한 상품명, 수량, 가격
	- 증정 상품 내역: 프로모션에 따라 무료로 제공된 증정 상품의 목록
	- 금액 정보
		- 총구매액: 구매한 상품의 총 수량과 총 금액
		- 행사할인: 프로모션에 의해 할인된 금액
		- 멤버십할인: 멤버십에 의해 추가로 할인된 금액
		- 내실돈: 최종 결제 금액

### 구매

- [x]  상품명, 수량 입력

```java
구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])
[콜라-3],[에너지바-5]
```

- [ ]  멤버십 할인 입력받기

```java
멤버십 할인을 받으시겠습니까? (Y/N)
Y
```

- [ ]  계산 결과 출력

```java
===========W 편의점=============
상품명 수량 금액
콜라 3 3,000
에너지바 5 10,000
===========증 정=============
콜라 1
==============================
총구매액 8 13,000
행사할인 -1,000
멤버십할인 -3,000
내실돈 9,000

```

- [ ]  재구매 여부 물어보기

```java
감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)
Y
```