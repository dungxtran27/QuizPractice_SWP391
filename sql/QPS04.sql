USE [master]
GO
/****** Object:  Database [SWP391_QPS04] */
CREATE DATABASE [SWP391_QPS04]
 GO
 USE [SWP391_QPS04]
 GO
 
 -- tao database lan 1 
 CREATE TABLE [dbo].[User](
	[userId] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](255) NULL,
	[password] [nvarchar](150) NULL,
	[status] [bit] NULL,
	[email] [nvarchar](100) NULL,
	[phone] [nvarchar](100) NULL,
	[fullname] [nvarchar](100) NULL,
	[address] [nvarchar](100) NULL,
	[gender] [bit] NULL,
	[avatar] [nvarchar](max) NULL,
	[roleId] [int] NULL,
	[created_date] [datetime] NULL CONSTRAINT [DF_User_created_date]  DEFAULT (getdate()),
	[modify_date] [datetime] NULL CONSTRAINT [DF_User_modify_date]  DEFAULT (getdate()),
	[password_token] [nvarchar](45) NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[userId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
CREATE TABLE [dbo].[Role](
	[roleId] [int] IDENTITY(1,1) NOT NULL,
	[roleName] [nvarchar](255) NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[roleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [FK_User_Role] FOREIGN KEY([roleId])
REFERENCES [dbo].[Role] ([roleId])
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [FK_User_Role]
GO
CREATE TABLE [dbo].[Post](
	[postId] [int] IDENTITY(1,1) NOT NULL,
	[thumbnail] [varchar](255) NULL,
	[userId] [int] NULL,
	[categoryBlogId] [int] NULL,
	[content] [varchar](max) NULL,
	[created_date] [date] NULL CONSTRAINT [DF_Post_created_date]  DEFAULT (getdate()),
	[edit_date] [date] NULL,
	[status] [bit] NULL,
	[brifInfor] [varchar](255) NULL,
	[title] [varchar](255) NULL,
	[postFileId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[postId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
CREATE TABLE [dbo].[Blog](
	[blogId] [int] IDENTITY(1,1) NOT NULL,
	[blogName] [nvarchar](255) NULL,
	[subId] [int] NULL,
 CONSTRAINT [PK_Blog] PRIMARY KEY CLUSTERED 
(
	[blogId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[Post]  WITH CHECK ADD  CONSTRAINT [FK_Post_Blog] FOREIGN KEY([categoryBlogId])
REFERENCES [dbo].[Blog] ([blogId])
GO
ALTER TABLE [dbo].[Post] CHECK CONSTRAINT [FK_Post_Blog]

GO
SET IDENTITY_INSERT [dbo].[Role] ON 

INSERT [dbo].[Role] ([roleId], [roleName]) VALUES (1, N'ADMIN')
INSERT [dbo].[Role] ([roleId], [roleName]) VALUES (2, N'CUSTOMER')
INSERT [dbo].[Role] ([roleId], [roleName]) VALUES (3, N'EXPERT')
INSERT [dbo].[Role] ([roleId], [roleName]) VALUES (4, N'SALE')
INSERT [dbo].[Role] ([roleId], [roleName]) VALUES (5, N'MARKETING')
SET IDENTITY_INSERT [dbo].[Role] OFF

SET IDENTITY_INSERT [dbo].[User] ON 

INSERT [dbo].[User] ([userId], [username], [password], [status], [email], [phone], [fullname], [address], [gender], [avatar], [roleId], [created_date], [modify_date], [password_token]) VALUES (1, N'admin', N'123456', 1, N'admin123@gmail.com', N'09123456', N'Nguyễn Văn A', N'Hà Nội', 1, N'', 1, CAST(N'1900-01-01 00:00:00.000' AS DateTime), CAST(N'1900-01-01 00:00:00.000' AS DateTime), NULL)
INSERT [dbo].[User] ([userId], [username], [password], [status], [email], [phone], [fullname], [address], [gender], [avatar], [roleId], [created_date], [modify_date], [password_token]) VALUES (2, N'customer', N'123456', 1, N'customer123@gmail.com', N'09123456', N'Nguyễn Văn B', N'Hà Nội', 0, N'', 2, CAST(N'1900-01-01 00:00:00.000' AS DateTime), CAST(N'1900-01-01 00:00:00.000' AS DateTime), NULL)
INSERT [dbo].[User] ([userId], [username], [password], [status], [email], [phone], [fullname], [address], [gender], [avatar], [roleId], [created_date], [modify_date], [password_token]) VALUES (3, N'expert', N'123456', 1, N'expert123@gmail.com', N'09123456', N'Nguyễn Thị C', N'Hà Nội', 1, N'', 3, CAST(N'1900-01-01 00:00:00.000' AS DateTime), CAST(N'1900-01-01 00:00:00.000' AS DateTime), NULL)
INSERT [dbo].[User] ([userId], [username], [password], [status], [email], [phone], [fullname], [address], [gender], [avatar], [roleId], [created_date], [modify_date], [password_token]) VALUES (4, N'sale', N'123456', 1, N'sale123@gmail.com', N'091234567', N'Lê Thị D', N'Hà Nội', 0, N'', 4, CAST(N'1900-01-01 00:00:00.000' AS DateTime), CAST(N'1900-01-01 00:00:00.000' AS DateTime), NULL)
INSERT [dbo].[User] ([userId], [username], [password], [status], [email], [phone], [fullname], [address], [gender], [avatar], [roleId], [created_date], [modify_date], [password_token]) VALUES (5, N'marketing', N'123456', 1, N'marketing123@gmail.com', N'0912345678', N'Mai Văn E', N'Hà Nội', 1, N'', 5, CAST(N'1900-01-01 00:00:00.000' AS DateTime), CAST(N'1900-01-01 00:00:00.000' AS DateTime), NULL)
INSERT [dbo].[User] ([userId], [username], [password], [status], [email], [phone], [fullname], [address], [gender], [avatar], [roleId], [created_date], [modify_date], [password_token]) VALUES (6, N'test', N'123456', 1, N'dung1881basketball@gmail.com', N'397909866', N'Chu Minh Thuong', N'Ha Noi', 1, N'ba350ec8-3901-4c34-b621-5f041cce9220_400_400.png', 2, CAST(N'2022-06-22 20:00:41.927' AS DateTime), CAST(N'2022-07-19 17:30:30.023' AS DateTime), NULL)
INSERT [dbo].[User] ([userId], [username], [password], [status], [email], [phone], [fullname], [address], [gender], [avatar], [roleId], [created_date], [modify_date], [password_token]) VALUES (7, N'test2', N'123456', 1, N'dung1881basketball@gmail.com', N'397909866', N'Nguyen Ha Dung', N'Hà Nội', 1, N'ba350ec8-3901-4c34-b621-5f041cce9220_400_400.png', 2, CAST(N'2022-06-22 00:00:00.000' AS DateTime), CAST(N'2022-06-22 00:00:00.000' AS DateTime), NULL)
INSERT [dbo].[User] ([userId], [username], [password], [status], [email], [phone], [fullname], [address], [gender], [avatar], [roleId], [created_date], [modify_date], [password_token]) VALUES (13, N'thuongls1', N'123456', NULL, N'thuongcmhe153150@fpt.edu.vn', NULL, NULL, NULL, NULL, NULL, 2, CAST(N'2022-07-19 17:00:47.680' AS DateTime), CAST(N'2022-07-19 17:00:47.680' AS DateTime), NULL)
SET IDENTITY_INSERT [dbo].[User] OFF
SET IDENTITY_INSERT [dbo].[Blog] ON 

INSERT [dbo].[Blog] ([blogId], [blogName], [subId]) VALUES (1, N'Math 9', 1)
INSERT [dbo].[Blog] ([blogId], [blogName], [subId]) VALUES (2, N'English 9', 2)
INSERT [dbo].[Blog] ([blogId], [blogName], [subId]) VALUES (3, N'Social Biology Study ', 3)
INSERT [dbo].[Blog] ([blogId], [blogName], [subId]) VALUES (4, N'Laguage: Japan', 4)
INSERT [dbo].[Blog] ([blogId], [blogName], [subId]) VALUES (5, N'Scient: Robot', 5)
INSERT [dbo].[Blog] ([blogId], [blogName], [subId]) VALUES (6, N'Computer: C++', 6)
INSERT [dbo].[Blog] ([blogId], [blogName], [subId]) VALUES (7, N'Technical of Autometic', 7)
INSERT [dbo].[Blog] ([blogId], [blogName], [subId]) VALUES (8, N'Art FreeStyle', 8)
INSERT [dbo].[Blog] ([blogId], [blogName], [subId]) VALUES (9, N'Health about younger', 9)
SET IDENTITY_INSERT [dbo].[Blog] OFF
SET IDENTITY_INSERT [dbo].[Post] ON 

INSERT [dbo].[Post] ([postId], [thumbnail], [userId], [categoryBlogId], [content], [created_date], [edit_date], [status], [brifInfor], [title], [postFileId]) VALUES (1, N'31a81f8e-02d7-4449-8fd3-705383ecfc4a_400_400.jpg', 1, 1, N'Colossal pyramids, imposing temples, golden treasures, enigmatic hieroglyphs, powerful pharaohs, strange gods, and mysterious mummies are features of Ancient Egyptian culture that have fascinated people over the millennia.  The Bible refers to its gods, rulers, and pyramids. Neighboring cultures in the ancient Near East and Mediterranean wrote about its god-like kings and its seemingly endless supply of gold.  The Greeks and Romans describe aspects of Egypts culture and history.<br> As the 19th century began, the Napoleonic campaign in Egypt highlighted the wonders of this ancient land, and public interest soared.  Not long after, Champollion deciphered Egypts hieroglyphs and paved the way for other scholars to reveal that Egyptian texts dealt with medicine, dentistry, veterinary practices, mathematics, literature, and Usering, and many other topics. Then, early in the 20th century, Howard Carter discovered the tomb of Tutankhamun and its fabulous contents. Exhibitions of this treasure a few decades later resulted in the worlds first blockbuster, and its revival in the 21st century has kept interest alive.<br> Join Dr. David Silverman, Professor of Egyptology at Penn, Curator in Charge of the Egyptian Section of the Penn Museum, and curator of the Tutankhamun exhibitions  on a guided tour of the mysteries and wonders of this ancient land.  He has developed this online course and set it in the galleries of the world famous Penn Museum.  He uses many original Egyptian artifacts to illustrate his lectures as he guides students as they make their own discovery of this fascinating culture.', CAST(N'2022-06-02' AS Date), CAST(N'2022-07-05' AS Date), 1, N'Math Phan so', N'Math Practice', 1)
INSERT [dbo].[Post] ([postId], [thumbnail], [userId], [categoryBlogId], [content], [created_date], [edit_date], [status], [brifInfor], [title], [postFileId]) VALUES (2, N'b1a9da7a-8f9d-46c4-a3f3-b6c6834a6efa_400_400.png', 2, 2, N'Physical indicates connected with, pertaining to, the animal or human body as a material organism: physical strength, exercise. Bodily means belonging to, concerned with, the human body', CAST(N'2021-08-09' AS Date), CAST(N'2021-07-10' AS Date), 1, N'Portugal', N'Physical', 2)
INSERT [dbo].[Post] ([postId], [thumbnail], [userId], [categoryBlogId], [content], [created_date], [edit_date], [status], [brifInfor], [title], [postFileId]) VALUES (3, N'ba350ec8-3901-4c34-b621-5f041cce9220_400_400.png', 3, 3, N'Computer software is programming code executed on a computer processor. The code can be machine-level code, or code written for an operating system.', CAST(N'2021-11-06' AS Date), CAST(N'2022-05-24' AS Date), 1, N'Computer', N'Computer', 3)
SET IDENTITY_INSERT [dbo].[Post] OFF






