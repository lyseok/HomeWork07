<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="pc-sidebar">
  <div class="navbar-wrapper">
    <div class="m-header">
      <a href="${pageContext.request.contextPath }" class="b-brand text-primary">
        <!-- ========   Change your logo from here   ============ -->
        <img src="${pageContext.request.contextPath }/resources/dist/assets/images/logo-dark.svg" class="img-fluid logo-lg" alt="logo">
      </a>
    </div>
    <div class="navbar-content">
      <ul class="pc-navbar">
        <li class="pc-item">
          <a href="${pageContext.request.contextPath }" class="pc-link">
            <span class="pc-micon"><i class="ti ti-dashboard"></i></span>
            <span class="pc-mtext">Dashboard</span>
          </a>
        </li>

        <li class="pc-item pc-caption">
          <label>회원관리</label>
          <i class="ti ti-dashboard"></i>
        </li>
        <li class="pc-item">
          <a href="${pageContext.request.contextPath }/people/list" class="pc-link">
            <span class="pc-micon"><i class="ti ti-typography"></i></span>
            <span class="pc-mtext">회원 목록</span>
          </a>
        </li>
        <li class="pc-item">
          <a href="${pageContext.request.contextPath }/people/new" class="pc-link">
            <span class="pc-micon"><i class="ti ti-typography"></i></span>
            <span class="pc-mtext">회원 등록</span>
          </a>
        </li>

    
      </ul>
      
    </div>
  </div>
</nav>