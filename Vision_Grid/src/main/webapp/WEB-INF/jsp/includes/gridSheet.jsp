<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<div>
    <p><c:out value="${loggedInUser.userName}" />さんの目標シート</p>
    <p><c:out value="${vision.visionKey}" /></p>

	<div class="grid-sheet">
	    <!-- GRIDの1行目 -->
	    <div>
	        <c:set var="positions" value="${['e1_A', 'e1_B', 'e1_C', 'e2_A', 'e2_B', 'e2_C', 'e3_A', 'e3_B', 'e3_C']}" />
	        <%@ include file="/WEB-INF/jsp/includes/_gridRow.jspf" %>
	    </div>
	
	    <!-- GRIDの2行目 -->
	    <div>
	        <c:set var="positions" value="${['e1_D', 'e1', 'e1_E', 'e2_D', 'e2', 'e2_E', 'e3_D', 'e3', 'e3_E']}" />
	        <%@ include file="/WEB-INF/jsp/includes/_gridRow.jspf" %>
	    </div>
	
	    <!-- GRIDの3行目 -->
	    <div>
	        <c:set var="positions" value="${['e1_F', 'e1_G', 'e1_H', 'e2_F', 'e2_G', 'e2_H', 'e3_F', 'e3_G', 'e3_H']}" />
	        <%@ include file="/WEB-INF/jsp/includes/_gridRow.jspf" %>
	    </div>
	
	    <!-- GRIDの4行目 -->
	    <div>
	        <c:set var="positions" value="${['e4_A', 'e4_B', 'e4_C', 'e1', 'e2', 'e3', 'e5_A', 'e5_B', 'e5_C']}" />
	        <%@ include file="/WEB-INF/jsp/includes/_gridRow.jspf" %>
	    </div>
	
	    <!-- GRIDの5行目 -->
	    <div>
	        <c:set var="positions" value="${['e4_D', 'e4', 'e4_E', 'e4', 'vision', 'e5', 'e5_D', 'e5', 'e5_E']}" />
	        <%@ include file="/WEB-INF/jsp/includes/_gridRow.jspf" %>
	    </div>
	
	    <!-- GRIDの6行目 -->
	    <div>
	        <c:set var="positions" value="${['e4_F', 'e4_G', 'e4_H', 'e6', 'e7', 'e8', 'e5_F', 'e5_G', 'e5_H']}" />
	        <%@ include file="/WEB-INF/jsp/includes/_gridRow.jspf" %>
	    </div>
	
	    <!-- GRIDの7行目 -->
	    <div>
	        <c:set var="positions" value="${['e6_A', 'e6_B', 'e6_C', 'e7_A', 'e7_B', 'e7_C', 'e8_A', 'e8_B', 'e8_C']}" />
	        <%@ include file="/WEB-INF/jsp/includes/_gridRow.jspf" %>
	    </div>
	
	    <!-- GRIDの8行目 -->
	    <div>
	        <c:set var="positions" value="${['e6_D', 'e6', 'e6_E', 'e7_D', 'e7', 'e7_E', 'e8_D', 'e8', 'e8_E']}" />
	        <%@ include file="/WEB-INF/jsp/includes/_gridRow.jspf" %>
	    </div>
	
	    <!-- GRIDの9行目 -->
	    <div>
	        <c:set var="positions" value="${['e6_F', 'e6_G', 'e6_H', 'e7_F', 'e7_G', 'e7_H', 'e8_F', 'e8_G', 'e8_H']}" />
	        <%@ include file="/WEB-INF/jsp/includes/_gridRow.jspf" %>
	    </div>
	</div>
</div>
