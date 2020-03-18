
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>网站标题</title>
<style type="text/css">
        .talk_con{
            width:600px;
            height:545px;
            border:1px solid #666;
            margin:-50px ;
            margin-left: -65px;
            background:#f9f9f9;
        }
        .talk_show{
            width:580px;
            height:480px;
            border:1px solid #666;
            background:#fff;
            margin:10px auto 0;
            overflow:auto;
        }
        .talk_input{
            width:580px;
            margin:10px auto 0;
        }
        .whotalk{
            width:80px;
            height:30px;
            float:left;
            outline:none;
        }
        .talk_word{
            width:512px;
            height:26px;
            padding:0px;
            float:left;
            margin-left:0px;
            outline:none;
            text-indent:10px;
        }        
        .talk_sub{
            width:56px;
            height:30px;
            float:left;
            margin-left:10px;
        }
        .atalk{
           margin:10px; 
        }
        .atalk span{
            display:inline-block;
            background:#0181cc;
            border-radius:10px;
            color:#fff;
            padding:5px 10px;
        }
        .btalk{
            margin:10px;
            text-align:right;
        }
        .btalk span{
            display:inline-block;
            background:#ef8201;
            border-radius:10px;
            color:#fff;
            padding:5px 10px;
        }
    </style>

<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/style2.css" />
<link rel="stylesheet" type="text/css" href="css/litewebchat.min.css"  /> <!--气泡 -->
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery.slide.js" type="text/javascript"></script>
<script type="text/javascript" src="js/script.js"></script>

<!--[if lt IE 9]> <script type="text/javascript" src="js/html5.js"> </script><![endif]-->
<!--[if IE 6]>
    <script type="text/javascript" src="js/DD_belatedPNG.js" ></script>
    <script> DD_belatedPNG.fix('img,div,li,em,i,h3,.png'); </script>
    <![endif]-->
<script>
    function toChat() {

	var Words = document.getElementById("words"); //显示窗口
	var Who = document.getElementById("who"); //A还是B
	var TalkWords = document.getElementById("talkwords"); //
	var TalkSub = document.getElementById("talksub");
	var Ashow=document.getElementById("Ashow");
	var Bshow=document.getElementById("Bshow");
	var str = "";

	
	if(TalkWords.value == "") {
		// 消息为空时弹窗
		alert("消息不能为空");
		return;
	}

		//如果Who.value为0n那么是 A说

		

		str = '<div class="lite-chatbox"><div class="cright cmsg"><img class="headIcon radius" ondragstart="return false;" oncontextmenu="return false;" src="./img/B.jpg" /><span class="name">您</span><span class="content">' + TalkWords.value;
		str+='</span></div></div>';

            $.ajax({
                //直接"post"或者"get",不需要"doPost","doGet"，该函数到后端接收缓冲区会自动匹配
            type:"post",
            url:"ChatClientServlet",//servlet文件名为Calculator，需要提前在web.xml里面注册，也可以在servlet界面通过@webServlet注册
            //dateType:"text",//数据类型，可以为json，xml等等，自己百度
            data:{"sendMessage":TalkWords.value},//操作数
            success:function(data){
                //发送成功
               // alert("success");//data为后端post函数传递来的数据，这里写结果操作代码
                str = '<div class="lite-chatbox"><div class="cleft cmsg"><img class="headIcon radius" ondragstart="return false;" oncontextmenu="return false;" src="./img/A.jpg" /><span class="name">医生</span><span class="content">' + data ;
                str+='</span></div></div>';
                //alert(data);
                Words.innerHTML = Words.innerHTML + str;
            }, error:function(data){
                alert(data);
            }
        })


		//location.href="ChatSendServlet?str="+TalkWords.value;

	Words.innerHTML = Words.innerHTML + str;
	TalkWords.value=" ";

}</script>

</head>
<body>

<!-- header -->
<header>
      <div class="com-wrap">  
         <div class="logo fl"><img src="images/oline_logo.png" height="24" width="83" alt=""></div>
         <div class="title fl">门诊在线咨询</div>
         <div class="telbar fr">
             服务热线：400-028-9555
         </div>
         <div class="clear"></div>
      </div>
      
  </header>
<!-- /header -->
<!-- main -->
<div class="main com-wrap">

	<div class="windl fl">
		<div class="windbox">

			<div class="msgbox">
				<div class="talk_con">
					<div class="talk_show" id="words">
						<div class="lite-chatbox">
							<div class="tips"><span class="tips" id="talksub">尊敬的客户,你好！为了向你提供优质快捷方便的服务，欢迎随时咨询相关牙齿问题</span></div>
						</div>
						<div class="lite-chatbox">
							<div class="cleft cmsg">
								<img class="headIcon radius" ondragstart="return false;" oncontextmenu="return false;" src="./img/A.jpg" />
								<span class="name">医生</span>
								<span class="content" >您好，请问有什么能帮您的</span>
							</div>
						</div>
						
					</div>

					<div class="talk_input">

						<input type="text" class="talk_word" id="talkwords">
						<input type="button" value="发送" class="talk_sub" onclick="toChat()">
					</div>
				</div>

			</div>
		</div>

	</div>
      <div class="windr fr">
        <div class="hd">
            <ul>
                <li>常见问题</li>
                <li>牙科知识</li>
                <li>其他</li>
            </ul>
        </div>
        <div class="bd">
            <div class="conWrap">
                <div class="con">
                 <ul>
                   <li><a href="###">1、龋齿的发病原因及防治 ？</a></li>
                   <li><a href="###">2、什么人需要作窝沟封闭？</a></li>
                   <li><a href="###">3、牙齿颜色异常有几种可能？</a></li>
                   <li><a href="###">4、牙齿颜色异常有几种可能？</a></li>
                   <li><a href="###">5、活动假牙与固定假牙之间有什么区别？</a></li>
                   <li><a href="###">6、多大年龄做正畸治疗合适？</a></li>
                   <li><a href="###">7、为什么要定期进行口腔检查？</a></li>
                   <li><a href="###">8、为什么要洗牙？</a></li>
                   <li><a href="###">9、牙齿缺失为什么要按时镶复？</a></li>
                   <li><a href="###">10、牙颌畸形有什么危害？</a></li>
                   <li><a href="###">11、口腔健康的标准是什么？</a></li>
                   <li><a href="###">12、急求冬季保健知识？</a></li>
                   <li><a href="###">13、多大年龄做正畸治疗合适？</a></li>
                   <li><a href="###">14、多大年龄做正畸治疗合适？</a></li>
                 </ul>
                </div>
                <div class="con">
                   <ul>
                   <li><a href="###">1、龋齿的发病原因及防治 ？</a></li>
                   <li><a href="###">2、什么人需要作窝沟封闭？</a></li>
                   <li><a href="###">3、牙齿颜色异常有几种可能？</a></li>
                   <li><a href="###">4、牙齿颜色异常有几种可能？</a></li>
                   <li><a href="###">5、活动假牙与固定假牙之间有什么区别？</a></li>
                   <li><a href="###">6、多大年龄做正畸治疗合适？</a></li>
                   <li><a href="###">7、为什么要定期进行口腔检查？</a></li>
                   <li><a href="###">12、急求冬季保健知识？</a></li>
                   <li><a href="###">13、多大年龄做正畸治疗合适？</a></li>
                   <li><a href="###">14、多大年龄做正畸治疗合适？</a></li>
                 </ul>
                </div>
                <div class="con">
                    <ul>
                   <li><a href="###">1、龋齿的发病原因及防治 ？</a></li>
                   <li><a href="###">2、什么人需要作窝沟封闭？</a></li>
                   <li><a href="###">3、牙齿颜色异常有几种可能？</a></li>
                   <li><a href="###">4、牙齿颜色异常有几种可能？</a></li>
                   <li><a href="###">5、活动假牙与固定假牙之间有什么区别？</a></li>
                   <li><a href="###">6、多大年龄做正畸治疗合适？</a></li>
                   <li><a href="###">7、为什么要定期进行口腔检查？</a></li>
                   <li><a href="###">8、为什么要洗牙？</a></li>
                   <li><a href="###">9、牙齿缺失为什么要按时镶复？</a></li>
                   <li><a href="###">10、牙颌畸形有什么危害？</a></li>
                 
                 </ul>
                </div>
            </div>
        </div>

        <div class="lnktools">
          <div class="tit"><img src="images/oline_tit_bg.png" alt=""></div>

  
           <div class="box fl">
             <div class="thumb"><a href="###"><img src="images/oline_winr_img1.png" alt=""></a></div>
             <p>地址路线</p>
           </div>
           <div class="box fl">
             <div class="thumb"><a href="###"><img src="images/oline_winr_img2.png" alt=""></a></div>
             <p>在线预约</p>
           </div>
           <div class="box fl">
             <div class="thumb"><a href="###"><img src="images/oline_winr_img3.png" alt=""></a></div>
             <p>其他</p>
           </div>
        <div class="clear"></div>
        </div>

      </div>

      <div class="clear"></div>

</div>
<!-- /main --> 

  <script type="text/javascript">
      jQuery(".windr").slide({ mainCell:".conWrap", targetCell:".more a", effect:"fold"});
  </script>
<!-- footer -->

<footer>
  
</footer>
<!-- /footer -->


</body>
</html>