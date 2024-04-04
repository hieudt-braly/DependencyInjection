# **DEPENDENCY INJECTION** 

```
Là pattern định nghĩa cách các dependencies nên được provided như nào theo IoC principle và D trong SOLID principle.
```

## **1. IoC vs D trong SOLID**
- IoC: Các class có dependency không nên tạo instance của dependency.
- D trong SOLID:
  - Các module cấp cao không nên phục thuốc các module cấp thấp.
  - Các thực thể nên phụ thuộc vào Abstract, không phụ thuộc vào Class hay Function nào cụ thể.

## **2. Lý do**
> Dễ dàng bảo trì, test, sửa đổi và extend.

## **3. Các Frameworks**
### **3.1. Dagger**
- Sử dụng các Annotation:
  - @Module: Class cung cấp các dependencies.
  - @Provides: Cung cấp 1 dependency.
  - @Component: Interface tạo ra 1 graph dependencies.
  - @Inject: Đánh dấu đối tượng sử dụng dependency.
```
- Khi cần inject 1 dependency, Dagger sẽ tìm trong graph dependencies mà ta đã tạo bằng @Component để cung cấp.

- Class được inject sẽ không biết dependency được tạo ra như nào. Dagger sẽ tạo ra 1 **Factory** để provide dependency trong compile-time.
```
### **3.2. Hilt**
- Hilt được xây dựng dựa trên Dagger.
- Khác biệt: Hilt giúp đơn giản hoá việc cung cấp DI. Thay vì phải tự tạo 1 graph dependencies như Dagger, Hilt sẽ tự tạo ra graph dependencies dựa trên các Annotation.
- Các annotation khá tương đồng với Dagger. Nhưng sẽ không dùng @Component mà sẽ dùng @HiltAndroidApp trong Application Class để tự generate code trong compile-time.

### **3.3. Koin**
- Koin có cách tiếp cận khác hẳn so với Dagger và Kotlin.
- Koin sẽ không dùng Anotation và không generate code trong compile-time.
- Để sử dụng Koin ta sẽ phải tạo 1 class chứa các module cung cấp dependencies. Và khai báo chúng trong Application Class.
> Tuy nhiên, Koin sẽ cung cấp các dependencies qua by Inject() và hàm này sẽ gọi tới 1 hàm get() trong nó. Điều này khiến Koin không đúng với DI pattern vì class sẽ biết dependency được cung cấp thế nào. Nó giống với Service Locator pattern hơn là DI. Tuy nhiên nó vẫn rất hiệu quả khi cần tuân thủ IoC principle.

## **4. Dagger/ Hilt vs Koin**
- Dagger/ Hilt: 
  - Thời gian compile-time lâu hơn vì phải generate code.
  - Số lượng file được compile nhiều.
  - Bug sẽ hiện ngay ở compile-time => Dễ phát hiện và xử lý bug.
- Koin:
  - Thời gian compile-time nhanh hơn.
  - Nếu không cẩn thận sẽ có lỗi trong runtime, thậm chí còn bị phát hiện rất muộn.
  - Dễ khai triển.
  - Ảnh hưởng hiệu năng runtime vì xử lý tìm dependencies trong runtime.