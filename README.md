# Example of Spring Data JPA Auditing

## API Design

### API: Get Product Detail

#### คำอธิบาย
สำหรับแสดงข้อมูลของสินค้าชิ้นนั้น

#### URL: /api/v1/product/:id
> Example: /api/v1/product/2
#### METHOD: GET

##### Request
###### Header
```json
{
    "Accept": "application/json"
}
```

##### Response
###### Status Code 
```text
status code : 200
```

##### Header
```blank
-
```
##### Body
```json
{
    "id": 2,
    "product_name": "43 Piece dinner Set",
    "product_price": 12.95,
    "product_image": "/43_Piece_dinner_Set.png",
    "quantity": 10,
    "product_brand": "CoolKidz",
    "last_update": "2021-01-06 13:47:05.886"
}
```

| **Name**  | **Type**     | **Description**  |
|---------|----------|--------|
| product_name | string | ชื่อสินค้า |
| product_price | decimal | ราคาสินค้า |
| product_quantity | int | จำนวนสินค้า |
| product_brand | string | ยี่ห้อสินค้า |
| product_image | string | รูปภาพสินค้า |
| last_update | string | วัน-เวลาที่มีการเปลี่ยนแปลงครั้งล่าสุด |
