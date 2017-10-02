


<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Page -->
<!--header start-->
<header id="header" <c:if test="${viewModel.slug != 'page-login'}"> class="tt-nav nav-border-bottom"</c:if>>
</header>
<c:choose>
    <c:when test="${viewModel.slug != 'page-login'}">
        <!--[if lt IE 8]>
        <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
        <nav class="site-navbar navbar navbar-default navbar-fixed-top navbar-mega" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggler hamburger hamburger-close navbar-toggler-left hided" data-toggle="menubar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="hamburger-bar"></span>
                </button>
                <button type="button" class="navbar-toggler collapsed" data-target="#site-navbar-collapse" data-toggle="collapse">
                    <i class="icon wb-more-horizontal" aria-hidden="true"></i>
                </button>
                <div class="navbar-brand navbar-brand-center" data-toggle="gridmenu">
                    <img class="navbar-brand-logo" src="assets/images/logo.png" title="AEB">

                </div>
                <button type="button" class="navbar-toggler collapsed" data-target="#site-navbar-search" data-toggle="collapse">
                    <span class="sr-only">Toggle Search</span>
                    <i class="icon wb-search" aria-hidden="true"></i>
                </button>
            </div>
            <div class="navbar-container container-fluid">
                <!-- Navbar Collapse -->
                <div class="collapse navbar-collapse navbar-collapse-toolbar" id="site-navbar-collapse">
                    <ul class="menu-head">
                        <li onclick="window.location = '${innerPrefix}request-3'" class="<c:if test="${selectedTab == 10}">active</c:if>">
                            <a href="#" class="waves-effect waves-classic"><i class="fa fa-map-marker" aria-hidden="true"></i> Locations</a>
                        </li>
                        <li onclick="window.location = '${innerPrefix}exchange-rates'" class="<c:if test="${selectedTab == 11}">active</c:if>">
                            <a href="#" class="waves-effect waves-classic"><i class="fa fa-exchange" aria-hidden="true"></i> Exchange Rates</a></li>
                        <li>
                            <a href="#" class="waves-effect waves-classic"> <i class="fa fa-calendar-o" aria-hidden="true"></i> Events Calendar</a></li>
                    </ul>
                    <!-- Navbar Toolbar Right -->
                    <ul class="nav navbar-toolbar navbar-right navbar-toolbar-right">
                        <li class="nav-item dropdown">
                            <a class="nav-link waves-effect waves-classic " data-toggle="dropdown" href="javascript:void(0)" aria-expanded="false" role="button">
                                <span class="flag-icon flag-icon-us"></span>
                            </a>
                            <div class="dropdown-menu" role="menu">
                                <a class="dropdown-item " href="javascript:void(0)" role="menuitem">
                                    <span class="flag-icon flag-icon-am"></span> Armenian</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link waves-effect waves-classic "  href="${innerPrefix}mailbox" title="Messages" aria-expanded="false" role="button">
                                <i class="material-icons">&#xE0BE;</i>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right dropdown-menu-media" role="menu">
                                <div class="dropdown-menu-header" role="presentation">
                                    <span class="badge badge-round badge-mess">New 3</span>
                                    <h5>MESSAGES</h5>
                                </div>
                                <div class="list-group" role="presentation">
                                    <div data-role="container">
                                        <div data-role="content">
                                            <a class="list-group-item" href="javascript:void(0)" role="menuitem">
                                                <div class="media">
                                                    <div class="pr-10">
                                                    <span class="avatar">
                                         <span class="icon-ic-government-payments"></span>
                                                    </span>
                                                    </div>
                                                    <div class="media-body">
                                                        <h6 class="media-heading">Card replacement</h6>
                                                        <div class="media-meta">
                                                            <time datetime="2017-06-17T20:22:05+08:00">30 minutes ago</time>
                                                        </div>
                                                        <div class="media-detail">Lorem ipsoum dolor sit...</div>
                                                    </div>
                                                </div>
                                            </a>
                                            <a class="list-group-item" href="javascript:void(0)" role="menuitem">
                                                <div class="media">
                                                    <div class="pr-10">
                                                    <span class="avatar">
                                         <span class="icon-ic-government-payments"></span>
                                                    </span>
                                                    </div>
                                                    <div class="media-body">
                                                        <h6 class="media-heading">Peroidic Transfers</h6>
                                                        <div class="media-meta">
                                                            <time datetime="2017-06-17T12:30:30+08:00">12 hours ago</time>
                                                        </div>
                                                        <div class="media-detail">Lorem ipsum Id consectetur et minim</div>
                                                    </div>
                                                </div>
                                            </a>
                                            <a class="list-group-item" href="javascript:void(0)" role="menuitem">
                                                <div class="media">
                                                    <div class="pr-10">
                                                    <span class="avatar">
                                         <span class="icon-ic-government-payments"></span>
                                                    </span>
                                                    </div>
                                                    <div class="media-body">
                                                        <h6 class="media-heading">Account Problem</h6>
                                                        <div class="media-meta">
                                                            <time datetime="2017-06-16T18:38:40+08:00">2 days ago</time>
                                                        </div>
                                                        <div class="media-detail">Lorem ipsum Id consectetur et minim</div>
                                                    </div>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <div class="dropdown-menu-footer" role="presentation">
                                    <a class="dropdown-menu-footer-btn" href="javascript:void(0)" role="button">
                                        <i class="icon wb-settings" aria-hidden="true"></i>
                                    </a>
                                    <a class="dropdown-item" href="javascript:void(0)" role="menuitem">
                                        See all messages
                                    </a>
                                </div>
                            </div>
                            <span class="badge badge-pill badge-mess up">3</span>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link waves-effect waves-classic " data-toggle="dropdown" href="javascript:void(0)" title="Notifications" aria-expanded="false" role="button">
                                <i class="material-icons">&#xE7F7;</i>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right dropdown-menu-media" role="menu">
                                <div class="dropdown-menu-header">
                                    <span class="badge badge-round badge-not">New 3</span>
                                    <h5>NOTIFICATIONS</h5>
                                </div>
                                <div class="list-group">
                                    <div data-role="container">
                                        <div data-role="content">
                                            <a class="list-group-item dropdown-item" href="javascript:void(0)" role="menuitem">
                                                <div class="media">
                                                    <div class="pr-10">
                                                        <span class="icon-ic-loans notify"></span>
                                                    </div>
                                                    <div class="media-body">
                                                        <h6 class="media-heading">Payment next week Wednesday</h6>
                                                        <time class="media-meta" datetime="2017-06-12T20:50:48+08:00">5 hours ago</time>
                                                    </div>
                                                </div>
                                            </a>
                                            <a class="list-group-item dropdown-item" href="javascript:void(0)" role="menuitem">
                                                <div class="media">
                                                    <div class="pr-10">
                                                        <span class="icon-ic-cards notify"></span>
                                                    </div>
                                                    <div class="media-body">
                                                        <h6 class="media-heading">Master Card 1555 6578 9874 9654 expires next month</h6>
                                                        <time class="media-meta" datetime="2017-06-11T18:29:20+08:00">2 days ago</time>
                                                    </div>
                                                </div>
                                            </a>
                                            <a class="list-group-item dropdown-item" href="javascript:void(0)" role="menuitem">
                                                <div class="media">
                                                    <div class="pr-10">
                                                        <span class="icon-ic-accounts notify"></span>
                                                    </div>
                                                    <div class="media-body">
                                                        <h6 class="media-heading">Account Balance changed</h6>
                                                        <time class="media-meta" datetime="2017-06-11T14:05:00+08:00">2 days ago</time>
                                                    </div>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <div class="dropdown-menu-footer">
                                    <a class="dropdown-menu-footer-btn" href="javascript:void(0)" role="button">
                                        <i class="icon md-settings" aria-hidden="true"></i>
                                    </a>
                                    <a class="dropdown-item" href="javascript:void(0)" role="menuitem">
                                        All notifications
                                    </a>
                                </div>
                            </div>
                            <span class="badge badge-pill badge-not up">3</span>
                        </li>

                        <li class="nav-item dropdown userpic-name">
                            <a class="nav-link navbar-avatar waves-effect waves-classic " data-toggle="dropdown" href="#" aria-expanded="false" role="button">
                                <img src="http://www.theplace.ru/archive/charles_aznavour/img/arton17085.jpg" alt="...">
                            </a>
                            <div class="dropdown-menu" role="menu">



                                <a class="dropdown-item active-user" onclick="changeCurrentClient(${user.currentClient.id})"  role="menuitem"><div id="initials">${user.currentClient.initials}</div> ${user.currentClient.firstName} ${user.currentClient.lastName}</a>
                                <div class="dropdown-divider" role="presentation"></div>
                                <c:forEach items="${user.clients}" var="client">
                                    <c:if test="${client.id != user.currentClient.id}">
                                        <a class="dropdown-item" onclick="changeCurrentClient(${client.id})"  role="menuitem"><div id="initials">${client.initials}</div> ${client.firstName} ${client.lastName}</a>
                                    </c:if>
                                </c:forEach>

                                <div class="dropdown-divider" role="presentation"></div>
                                <a class="dropdown-item" href="${innerPrefix}contacts" role="menuitem"><i class="icon wb-user" aria-hidden="true"></i> Contacts</a>
                                <a class="dropdown-item" href="${innerPrefix}profile" role="menuitem"><i class="icon wb-settings" aria-hidden="true"></i> Profile</a>
                                <div class="dropdown-divider" role="presentation"></div>
                                <a class="dropdown-item" href="${innerPrefix}logOut" role="menuitem"><i class="icon wb-power" aria-hidden="true"></i> Logout</a>
                            </div>
                            <%--<span id="username" data-toggle="dropdown" role="button">${user.currentClient.displayName} <i class="fa fa-angle-down" aria-hidden="true"></i></span>--%>
                        </li>
                    </ul>
                    <!-- End Navbar Toolbar Right -->
                </div>
                <!-- End Navbar Collapse -->
                <!-- Site Navbar Seach -->
                <div class="collapse navbar-search-overlap" id="site-navbar-search">
                    <form role="search">
                        <div class="form-group">
                            <div class="input-search">
                                <i class="input-search-icon wb-search" aria-hidden="true"></i>
                                <input type="text" class="form-control" name="site-search" placeholder="Search...">
                                <button type="button" class="input-search-close icon wb-close" data-target="#site-navbar-search" data-toggle="collapse" aria-label="Close"></button>
                            </div>
                        </div>
                    </form>
                </div>
                <!-- End Site Navbar Seach -->
            </div>
        </nav>
        <div class="site-menubar">
            <div class="site-menubar-body">
                <div>
                    <div>
                        <ul class="site-menu" data-plugin="menu">
                            <li class="site-menu-item <c:if test="${selectedTab == 1}">active</c:if> waves-effect waves-light">
                                <a href="overview" class=" icon-ic-overview">
                                    <span class="site-menu-title">Overview</span>
                                </a>
                            </li>
                            <li class="site-menu-item <c:if test="${selectedTab == 2}">active</c:if> waves-effect waves-light">
                                <a href="account" class=" icon-ic-accounts">
                                    <span class="site-menu-title">Accounts</span>
                                </a>
                            </li>
                            <li class="site-menu-item <c:if test="${selectedTab == 3}">active</c:if> waves-effect waves-light">
                                <a href="card" class="icon-ic-cards ">
                                    <span class="site-menu-title">Cards</span>
                                </a>
                            </li>
                            <li class="site-menu-item <c:if test="${selectedTab == 4}">active</c:if> waves-effect waves-light">
                                <a href="loan" class="icon-ic-loans ">
                                    <span class="site-menu-title">Loans</span>
                                </a>
                            </li>
                            <li class="site-menu-item <c:if test="${selectedTab == 5}">active</c:if> waves-effect waves-light" >
                                <a href="deposits" class="icon-ic-deposits" >
                                    <span class="site-menu-title">Deposits</span>
                                </a>
                            </li>
                            <li class="site-menu-item waves-effect waves-light <c:if test="${selectedTab == 6}">active</c:if>">
                                <a href="transfers" class="icon-ic-transfers">
                                    <span class="site-menu-title">Transfers</span>
                                </a>
                            </li>
                            <li class="site-menu-item waves-effect waves-light <c:if test="${selectedTab == 7}">active</c:if>">
                                <a href="requestsPage" class="icon-ic-online-request ">
                                    <span class="site-menu-title">Online Request</span>
                                </a>
                            </li>
                            <li class="site-menu-item waves-effect waves-light <c:if test="${selectedTab == 8}">active</c:if>">
                                <a href="payment" class="icon-ic-payments">
                                    <span class="site-menu-title">Payments</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </c:when>
</c:choose>
<input type="hidden" id="innerPrefix" value="${innerPrefix}">
<!--/. Sidebar navigation -->


<!--body content start-->




