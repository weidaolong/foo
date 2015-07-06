<%@page import="com.wdl.foo.entity.sys.SysResources"%>
<%@page import="java.util.List"%>
<%@include file="/taglibs.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    List<SysResources> categorys =(List<SysResources>) session.getAttribute("categorys");
    %>
   <div class="navbar-default sidebar" role="navigation">
       <div class="sidebar-nav navbar-collapse">
           <ul class="nav" id="side-menu">
           
           	<c:forEach items="${ categorys}" var="item">
           	
           	
               <li>
                   <a href="#"><i class="fa fa-sitemap fa-fw"></i> ${item.name }<span class="fa arrow"></span></a>
                   <ul class="nav nav-second-level">
	                   <c:forEach items="${ item.resList}" var="childItem">
                       <li>
                           <a href="${childItem.url }">${childItem.name }</a>
                       </li>
                       </c:forEach>
                   </ul>
               </li>
               </c:forEach>
           </ul>
       </div>
   </div>
