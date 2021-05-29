<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>MINGW's Library Admin Page</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="/css/styles2.css" rel="stylesheet" />
    <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</head>

<body>
    <!-- Responsive navbar-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container px-5">
            <a class="navbar-brand" href="/admin_index">MINGW's Library Admin Page</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li class="nav-item"><a class="nav-link active" aria-current="page" href="/admin_index">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="/">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Page Content-->
    <div class="container px-4 px-lg-5">
        <!-- Heading Row-->

        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">사서 추천 도서</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item active">추천 도서 추가</li>
                        <li class="breadcrumb-item"><a href="/admin/alarm/notice/good_delete">추천 도서 삭제</a></li>
                    </ol>

                    <!--                    추천 도서 목록-->
                    <div class="card mb-4">
                        <div class="card-body">
                            현재 추가 하고자 하는 추천 도서가 존재하는지 미리 확인하세요!
                        </div>
                    </div>
                    <div class="card mb-4">
                        <div class="card-header">
                            <i class="fas fa-table me-1"></i>
                            추천 도서 목록
                        </div>
                        <div class="card-body">
                            <table id="datatablesSimple">
                                <thead>
                                    <tr>
                                    	<th>ID</th>
                                        <th>ISBN</th>
                                        <th>제목</th>
                                        <th>날짜</th>
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                    	<th>ID</th>
                                        <th>ISBN</th>
                                        <th>제목</th>
                                        <th>날짜</th>
                                    </tr>
                                </tfoot>
                                <tbody>
                                    <tr>
                                    	<td>0</td>
                                        <td>123123</td>
                                        <td>쏘공에 대한 책</td>
                                        <td>2020-02-30</td>
                                    </tr>
                                    <tr>
                                    	<td>1</td>
                                        <td>123123</td>
                                        <td>호러관련 추천 도서</td>
                                        <td>2020-02-31</td>
                                    </tr>
                                    <tr>
                                    	<td>2</td>
                                        <td>123123</td>
                                        <td>쏘공에 대한 책</td>
                                        <td>2020-02-30</td>
                                    </tr>
                                    <tr>
                                    	<td>3</td>
                                        <td>123123</td>
                                        <td>호러관련 추천 도서</td>
                                        <td>2020-02-31</td>
                                    </tr>
                                    <tr>
                                    	<td>4</td>
                                        <td>123123</td>
                                        <td>쏘공에 대한 책</td>
                                        <td>2020-02-30</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <!--                추천 도서 추가 파트-->
                <div class="container px-4 px-lg-5">
                    <div class="row justify-content-center">
                        <div class="card shadow-lg border-5 rounded-lg mt-5">
                            <div class="card-header">
                                <h3 class="text-center font-weight-light my-4">추천 도서 추가</h3>
                            </div>
                            <div class="card-body">
                                <form>
									
									<div class="form-floating mb-3">
                                        <input class="form-control" id="inputGoodISBN" type="text" placeholder="추천할 책의 ISBN을 입력해주세요." />
                                        <label for="inputGoodISBN">추천할 책의 ISBN</label>
                                    </div>
                                
                                	<div class="form-floating mb-3">
                                        <input class="form-control" id="inputGoodTitle" type="text" placeholder="추천 도서 제목을 입력해주세요." />
                                        <label for="inputGoodTitle">추천 도서를 멋지게 설명할 주제 제목</label>
                                    </div>
                                    
                                    <div class="form-group">
                                    	<textarea class="form-control" id="inputGoodContent" placeholder="추천 도서 내용을 입력해주세요." rows="10"></textarea>
                                    </div>
                                    <div id="inputGoodContentCount">(0 / 1000)</div>
                                    
                                    <div class="mt-4 mb-0">
                                        <div class="d-grid"><input type="submit" class="btn btn-primary btn-block" value="추천 도서를 추가합니다." /></div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

            </main>
            <!-- Footer-->
            <footer class="m-5 py-5 bg-dark">
                <div class="container px-4 px-lg-5">
                    <p class="m-0 text-center text-white">Copyright &copy; MinGW's Library 2021</p>
                </div>
            </footer>
            <!-- Bootstrap core JS-->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
            <!-- Core theme JS-->
            <script src="/js/scripts.js"></script>
            <!--    회원 정의 추가용-->
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
            <!--        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>-->
            <!--    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/css/bootstrap.min.css" rel="stylesheet" />-->

            <!--        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">-->
            <!--        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>-->

            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"></script>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
            <script src="/js/dataTables.js"></script>
            
            <!-- 글자제한 -->
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
            <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
        </div>
    </div>
</body>

</html>
