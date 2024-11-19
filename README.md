# Currency Converter App
Ứng dụng Currency Converter là một ứng dụng di động được xây dựng bằng Android Studio sử dụng ngôn ngữ Kotlin. Ứng dụng cho phép người dùng nhập số tiền, chọn loại tiền tệ gốc và đích, sau đó hiển thị kết quả chuyển đổi dựa trên tỷ giá thực được lấy từ một API công cộng.

# Cấu trúc ứng dụng
1. Thư mục chính
 - manifests/: Chứa tệp AndroidManifest.xml quản lý quyền và cấu hình hoạt động của ứng dụng.
 - kotlin+java/com.example.currencyconverter/: Chứa các tệp mã nguồn chính.
   + CurrencyApiService: Giao diện định nghĩa các phương thức gọi API.
   + CurrencyViewModel: Áp dụng mô hình MVVM, quản lý dữ liệu giữa UI và logic.
   + ExchangeRateResponse: Mô hình dữ liệu để ánh xạ phản hồi từ API.
   + MainActivity: Tệp chính xử lý giao diện và sự kiện người dùng.
   + RetrofitInstance: Tạo instance của Retrofit để kết nối API.
 - res/: Chứa tài nguyên giao diện và cấu hình.
   + drawable/: Các tài nguyên hình ảnh (ví dụ: hình nền, icon).
   + layout/: Tệp bố cục giao diện (activity_main.xml).
   + values/: Các tệp như strings.xml, colors.xml chứa chuỗi và màu sắc.
2. Các tệp cấu hình
 - build.gradle.kts: Cấu hình dependencies và build script.
 - local.properties: Tệp cài đặt đường dẫn SDK.

# Hướng dẫn cài đặt và chạy ứng dụng
  1. Sao chép dự án
   - Sử dụng lệnh sau để tải dự án về máy: git clone (https://github.com/quangth03/Challenge-Intern.git)
  2. Mở bằng Android Studio
   - Mở Android Studio.
   - Chọn Open an Existing Project và điều hướng đến thư mục dự án.
  3. Cài đặt thư viện
   - Đồng bộ dự án bằng cách mở tệp build.gradle.kts và nhấn Sync Now.
  4. Chạy ứng dụng
   - Kết nối thiết bị hoặc máy ảo Android.
   - Nhấn Run trong Android Studio để chạy ứng dụng.

# Link video demo Currency Converter App: 
  https://youtu.be/j92h0dJTf3Y
