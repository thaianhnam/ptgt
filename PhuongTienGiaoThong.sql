USE master
GO

--IF  EXISTS (SELECT name 
--			FROM sys.databases 
--			WHERE name = 'QLPhuongTien')
--	DROP DATABASE QLPhuongTien
GO
--Tạo CSDL
CREATE DATABASE QLPhuongTien
GO
--Sử dụng CSDL
USE QLPhuongTien
GO

------------------ Bảng NguoiDung-----------------
CREATE TABLE NguoiDung( 
	MaND char(15)  NOT NULL PRIMARY KEY,
	TenND nvarchar(50) NOT NULL,
	Tuoi int ,
	SoDT char(15) ,
	GioiTinh smallint,
	DiaChi nvarchar(50) ,
	ChucVu nvarchar(20) ,
	UserName nvarchar(30) NOT NULL,
	UserPass nvarchar(30) NOT NULL,
	Hinh image ,
)

INSERT INTO NguoiDung(MaND, TenND, Tuoi, SoDT, GioiTinh, DiaChi, ChucVu, UserName, UserPass, Hinh) VALUES
	('NV01', N'Trần Đình Hoàng', 21, '0963175352', 1, N'Nghi Xuân, Hà Tĩnh', N'Quản Lý', 'superadmin', '12345678', NULL),
	('NV02', N'Đặng Văn Hải', 21, '0977364155', 1, N'Từ Liêm, Hà Nội', N'Nhân Viên', 'admin1', '123456', NULL),
	('NV03', N'Thái Anh Nam', 21, '0844657355', 1, N'Thanh Xuân, Hà Nội', N'Nhân Viên', 'admin2', '1234567', NULL);

	



------------------ Bảng KhachHang -----------------
CREATE TABLE KhachHang(
	MaKH char(15) NOT NULL PRIMARY KEY,
	HoTen nchar(30) NOT NULL,
	GioiTinh  int NOT NULL,
	CMND int NOT NULL,
	DienThoai char(20) NOT NULL,
	NgaySinh Date,
	Email char(20),
	DiaChi nchar(30)
)

INSERT INTO KhachHang(MaKH, HoTen, GioiTinh, CMND, DienThoai, NgaySinh, Email, DiaChi) VALUES
	('KH001', N'Trần Thu Thủy', 0, 184415300, 0977468155,'1/1/2000','dinnhoang@gamil.com', N'Nghi Xuân - Hà Tĩnh'),
	('KH002', N'Trần Huyền Trang', 0, 184415334, 0977468345,'4/6/2000','thuthuy@gmail.com', N'Nghi Xuân - Hà Tĩnh'),
	('KH003', N'Bùi Văn Dương', 1, 184415654, 0977462355,'2/3/2000', 'vanduong@gmail.com', N'Thanh Xuân - Hà Nội');


------------------ Bảng XeMay -----------------
CREATE TABLE XeMay(
	MaXM char(15) NOT NULL PRIMARY KEY, 
	TenXe nchar(30) NOT NULL,
	HangSanXuat nchar(20) NOT NULL,
	NamSanXuat int NOT NULL,
	GiaBan float NOT NULL,
	MauSon nchar(20) NOT NULL,
	CongSuat float
)

INSERT INTO XeMay(MaXM, TenXe, HangSanXuat, NamSanXuat, GiaBan, MauSon, CongSuat) VALUES
	('XM01', 'Winner', 'HonDa', 2020, 10000, N'Xám', 150),
	('XM02', 'SH', 'HonDa', 2018, 20000, N'Trắng', 300),
	('XM03', 'Exciter', 'Yamaha', 2019, 30000, N'Đỏ', 150);

	------------------ Bảng XeTai -----------------
CREATE TABLE XeTai(
	MaXT char(15) NOT NULL PRIMARY KEY, 
	TenXe nchar(30) NOT NULL,
	HangSanXuat nchar(20) NOT NULL,
	NamSanXuat int NOT NULL,
	GiaBan float NOT NULL,
	MauSon nchar(20) NOT NULL,
	TrongTai float
)

INSERT INTO XeTai(MaXT, TenXe, HangSanXuat, NamSanXuat, GiaBan, MauSon, TrongTai) VALUES
	('XT01', 'Isuzu', 'Huyndai', 2020, 10000, N'Trắng', 10),
	('XT02', 'New Mighty', 'Huyndai', 2020, 10000, N'Vàng', 15),
	('XT03', 'EX8', 'BMW', 2020, 10000, N'Xanh', 20);

------------------ Bảng OTo -----------------
CREATE TABLE OTo(
	MaOT char(15) NOT NULL PRIMARY KEY, 
	TenXe nchar(30) NOT NULL,
	HangSanXuat nchar(20) NOT NULL,
	NamSanXuat int NOT NULL,
	GiaBan float NOT NULL,
	MauSon nchar(20) NOT NULL,
	KieuDongCo nchar(20),
	SoChoNgoi int
	
)

INSERT INTO OTo(MaOT, TenXe, HangSanXuat, NamSanXuat, GiaBan, MauSon, KieuDongCo, SoChoNgoi) VALUES
	('OT01', N'LUX A2.0', N'Vinfast', 2020, 90000, N'Đen', 'V8', 4),
	('OT02', N'Mercedes-Benz C200','MEC', 2018, 80000, N'Đỏ', 'I5', 5),
	('OT03', N'BMW 300i', N'BWM', 2019, 90000, N'Xanh', 'I4', 4);



	------------------ Bảng ThongTinXe -----------------
CREATE TABLE ThongTinXe(
	BienSo char(20) NOT NULL PRIMARY KEY,
	MaXM char(15) ,
	MaOT char(15) ,
	MaXT char(15) ,
	NgayDangKy date NOT NULL,
	TinhTrang nchar(30),
	CONSTRAINT FK_ThongTinXe_XeMay FOREIGN KEY(MaXM) REFERENCES XeMay(MaXM),
	CONSTRAINT FK_ThongTinXe_XeTai FOREIGN KEY(MaXT) REFERENCES XeTai(MaXT),
	CONSTRAINT FK_ThongTinXe_OTo FOREIGN KEY(MaOT) REFERENCES OTo(MaOT)
)
 
INSERT INTO ThongTinXe(BienSo, MaXM, MaOT, MaXT, NgayDangKy, TinhTrang) VALUES
	('38N1-2341','XM01', null, null, '2/3/2018', N'Hoạt đông tốt'),
	('38N1-2342','XM02', null, null, '2/3/2018', N'Hoạt đông tốt'),
	('38N1-2343','XM03', null, null, '2/3/2018', N'Hoạt đông tốt'),
	('24N1-2344',null, 'OT01', null, '6/3/2017', N'Hoạt đông tốt'),
	('24N1-2345',null, 'OT02', null, '6/3/2017', N'Hoạt đông tốt'),
	('24N1-2346',null, 'OT03', null, '6/3/2017', N'Hoạt đông tốt'),
	('35N1-2347',null, null, 'XT01', '2/4/2020' , N'Hoạt đông tốt'),
    ('35N1-2348',null, null, 'XT02', '2/4/2020' , N'Hoạt đông tốt'),
	('35N1-2349',null, null, 'XT03', '2/4/2020' , N'Hoạt đông tốt');

------------------------Bảng PhieuThue-----------------------------
CREATE TABLE PhieuThue(
	MaPT char(15) NOT NULL PRIMARY KEY,
	NgayThue date NOT NULL,
	MaKH char(15) NOT NULL,
	MaND char(15) NOT NULL,
	SoNgayThue int NOT NULL,
	BienSo char(20) NOT NULL,
	DonGiaNgay float NOT NULL,
	CONSTRAINT FK_PhieuThue_KhachHang FOREIGN KEY(MaKH) REFERENCES KhachHang(MaKH),
	CONSTRAINT FK_PhieuThue_NguoiDung FOREIGN KEY(MaND) REFERENCES NguoiDung(MaND),
	CONSTRAINT FK_PhieuThue_ThongTinXe FOREIGN KEY(BienSo) REFERENCES ThongTinXe(BienSo)
)

INSERT INTO PhieuThue(MaPT, NgayThue, MaKH, MaND, SoNgayThue, BienSo, DonGiaNgay) VALUES
	('PT01', '8/1/2021', 'KH001', 'NV01', 5,'38N1-2341', 1000000),
	('PT02', '10/1/2021', 'KH002', 'NV02', 7, '24N1-2345', 2000000),
	('PT03', '9/1/2021', 'KH003', 'NV03', 4, '35N1-2348', 3000000);

---------------------BangPhieuPhat--------------------------------------	
CREATE TABLE PhieuPhat(
	MaPP char(15) NOT NULL PRIMARY KEY,
	MaPT char(15) NOT NULL,
	NgayPhat date NOT NULL,
	NoiDungPhat nchar(100) NOT NULL,
	MaKH char(15) NOT NULL,
	MaND char(15) NOT NULL,
	TienPhat money NOT NULL,
	CONSTRAINT FK_PhieuPhat_PhieuThue FOREIGN KEY(MaPT) REFERENCES PhieuThue(MaPT)
)

INSERT INTO PhieuPhat(MaPP , MaPT, NgayPhat, NoiDungPhat,  MaKH, MaND, TienPhat) VALUES
	('PP01', 'PT01', '8/6/2021', N'Tai nan giao thong', 'KH001', 'NV01', 500000),
	('PP02', 'PT02', '10/6/2021', N'Xe chóc sơn', 'KH002', 'NV02', 500000),
	('PP03','PT03', '9/10/2021', N'Xe xịt lốp', 'KH003', 'NV03', 800000);

