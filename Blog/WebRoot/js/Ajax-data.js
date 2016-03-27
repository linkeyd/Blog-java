// JavaScript Document

var indexs = {
	carousel : function() {
		$
				.ajax({
					type : "GET",
					dataType : "json",
					// jsonp: 'callback',
					url : "SelectCarousel",
					success : function(data) {
						$(".carousel-indicators").html("");
						$(".carousel-inner").html("");
						$(".carousel-indicators")
								.append(
										'<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>');
						$(".carousel-inner").append(
								'<div class="item active"><img class="img-responsive img-full" src="'
										+ data[0].img + '" alt=""></div>');
						for (var i = 1; i < data.length; i++) {
							$(".carousel-indicators").append(
									'<li data-target="#carousel-example-generic" data-slide-to="'
											+ i + '"></li>');
							$(".carousel-inner").append(
									'<div class="item"><img class="img-responsive img-full" src="'
											+ data[i].img + '" alt=""></div>');
						}
						/*
						 * <ol class="carousel-indicators hidden-xs">
						 * <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						 * <li data-target="#carousel-example-generic" data-slide-to="1"></li>
						 * <li data-target="#carousel-example-generic" data-slide-to="2"></li>
						 * </ol>
						 * 
						 * <!-- Wrapper for slides 图片轮播 --> <div
						 * class="carousel-inner"> <div class="item active">
						 * <img class="img-responsive img-full"
						 * src="img/slide-1.jpg" alt=""> </div> <div
						 * class="item"> <img class="img-responsive img-full"
						 * src="img/slide-2.jpg" alt=""> </div> <div
						 * class="item"> <img class="img-responsive img-full"
						 * src="img/slide-3.jpg" alt=""> </div> </div>
						 */
					},
					timeout : (10000),
					error : function() {
						alert("您的网络目前不通畅获取失败,请重新刷新。");
					}
				})
	},
	blog : function() {
		$
				.ajax({
					type : "GET",
					dataType : "json",
					// jsonp: 'callback',
					url : "SelectBlog",
					success : function(data) {
						var text = data[0].contenct;
						var subd = text.substring(0, 230) + "......";
						$(".blog_contenct").html("");
						$(".blog_contenct")
								.append(
										'<div class="row" style="padding:15px;"><div class="col-md-6"><img src='
												+ data[0].img
												+ ' class="imgs img-thumbnail"></div><div class="col-md-6"><p>'
												+ subd + '</p></div></div>');

					},
					timeout : (10000),
					error : function() {
						alert("您的网络目前不通畅获取失败,请重新刷新。");
					}
				})
	},
	/*
	 * message:function(){ $.ajax({ type:"GET", dataType:"json", //jsonp:
	 * 'callback', url:"json/message.txt", success: function(data){
	 * $(".message_contenct").html("");
	 * $(".message_contenct").append(data[0].contenct); }, timeout:(10000),
	 * error: function(){ alert("您的网络目前不通畅获取失败,请重新刷新。"); } })
	 * 
	 * $.ajax({ type:"GET", dataType:"jsonp", jsonp: 'callback',
	 * url:"json/blog.json", success: function(data){
	 * $(".message_contenct").html("");
	 * $(".message_contenct").append(data[0].contenct); }, timeout:(10000),
	 * error: function(){ alert("您的网络目前不通畅获取失败,请重新刷新。"); } }) },
	 */
	work : function() {
		$
				.ajax({
					type : "GET",
					dataType : "json",
					// jsonp: 'callback',
					url : "SelectWork",
					success : function(data) {

						$(".worked").html("");
						for (var i = 0; i < data.length; i++) {

							$(".worked")
									.append(
											'<div class="col-sm-4"><div class="thumbnail"><a href="'
													+ data[i].url
													+ '"><img src="'
													+ data[i].img
													+ '" alt="'
													+ data[i].title
													+ '" class="imgs"></a><div class="caption"><h3>'
													+ data[i].title
													+ '</h3><p>'
													+ data[i].contenct
													+ '</p></div></div></div>')

						}
						$(".worked").append("<div class='clearfix'></div>")
						/*
						 * $(".worked").append('<div class="col-sm-4
						 * text-center"><a href="'+data[i].url+'"><img
						 * class="img-responsive img-thumbnail"
						 * src="'+data[i].img+'" alt=""></a><h3>'+data[i].title+'<small>'+data[i].time+'</small></h3></div>')
						 * <div class="col-sm-4"> <div class="thumbnail"> <a
						 * href="#"> <img src="http://placehold.it/750x450"
						 * alt="..." class="imgs"> </a> <div class="caption">
						 * <h3>Thumbnail label</h3> <p>...</p>
						 * 
						 * </div> </div> </div> <div class="clearfix"></div>
						 */
					},
					timeout : (10000),
					error : function() {
						alert("您的网络目前不通畅获取失败,请重新刷新。");
					}
				})
	}
};

var blog = {
	selects : function() {
		$
				.ajax({
					type : "GET",
					dataType : "json",
					// jsonp: 'callback',
					url : "SelectBlog",
					success : function(data) {
						$(".contenct").html("");

						var html = '';
						for (i = 0; i < data.length; i++) {
							var text = data[i].contenct;
							var subd = text.substring(0, 230) + "......";
							html += '<div class="col-lg-12 text-center blog">';
							html += '<h2>' + data[i].title + '';
							html += '<br>';
							html += '<small>' + data[i].time + '</small>';
							html += '</h2>';
							html += '<div class="row" style="padding:15px;"><div class="col-md-6"><img src='
									+ data[i].img
									+ ' class="imgs img-thumbnail"></div><div class="col-md-6"><p>'
									+ subd + '</p></div></div>';
							html += '<a  class="btn btn-default btn-lg blog_modal" data-toggle="modal" data-target=".bs-example-modal-lg">详细阅读</a>';
							html += '<hr>';
							html += '</div>';

						}
						$(".contenct").append(html);
						page_(data.length, "blog");// 分页函数回调
						modal(data);// 弹窗获取数据回调
					},
					timeout : (10000),
					error : function() {
						alert("您的网络目前不通畅获取失败,请重新刷新。");
					}
				})
	},
	page : function() {
	}
}

var xuexi = {
	languange_html : function() {
		$
				.ajax({
					type : "GET",
					dataType : "json",
					// jsonp: 'callback',
					url : "SelectLang",
					success : function(data) {
						$(".contenct").html("");

						var html = '';
						for (i = 0; i < data.length; i++) {
							var text = data[i].contenct;
							var subd = text.substring(0, 230) + "......";
							html += '<div class="col-lg-12 text-center blog">';
							html += '<h2>' + data[i].title + '';
							html += '<br>';
							html += '<small>' + data[i].time + '</small>';
							html += '</h2>';
							html += '<div class="row" style="padding:15px;"><div class="col-sm-6"><img src='
									+ data[i].img
									+ ' class="imgs img-thumbnail"></div><div class="col-sm-6"><p>'
									+ subd + '</p></div></div>';
							html += '<a  class="btn btn-default btn-lg blog_modal" id="blog_modal" data-toggle="modal" data-target=".bs-example-modal-lg">详细阅读</a>';
							html += '<hr>';
							html += '</div>';

						}
						$(".contenct").append(html);
						page_(data.length, "blog");// 分页函数回调

						modal_pen(data);// 弹窗获取数据回调

					},
					timeout : (10000),
					error : function() {
						alert("您的网络目前不通畅获取失败,请重新刷新。");
					}
				})
	},
	history : function() {
		$
				.ajax({
					type : "GET",
					dataType : "json",
					// jsonp: 'callback',
					url : "SelectHistory",
					success : function(data) {
						$(".contenct").html("");

						var html = '';
						for (i = 0; i < data.length; i++) {
							var text = data[i].contenct;
							var subd = text.substring(0, 230) + "......";
							html += '<div class="col-lg-12 text-center blog">';
							html += '<h2>' + data[i].title + '';
							html += '<br>';
							html += '<small>' + data[i].time + '</small>';
							html += '</h2>';
							html += '<div class="row" style="padding:15px;"><div class="col-sm-6"><img src='
									+ data[i].img
									+ ' class="imgs img-thumbnail"></div><div class="col-sm-6"><p>'
									+ subd + '</p></div></div>';
							html += '<a  class="btn btn-default btn-lg blog_modal" id="blog_modal" data-toggle="modal" data-target=".bs-example-modal-lg">详细阅读</a>';
							html += '<hr>';
							html += '</div>';

						}
						$(".contenct").append(html);
						page_(data.length, "blog");// 分页函数回调

						modal(data);// 弹窗获取数据回调

					},
					timeout : (10000),
					error : function() {
						alert("您的网络目前不通畅获取失败,请重新刷新。");
					}
				})
	},
	rest : function() {
		$
				.ajax({
					type : "GET",
					dataType : "json",
					// jsonp: 'callback',
					url : "SelectRest",
					success : function(data) {
						$(".contenct").html("");

						var html = '';
						for (i = 0; i < data.length; i++) {
							var text = data[i].contenct;
							var subd = text.substring(0, 230) + "......";
							html += '<div class="col-lg-12 text-center blog">';
							html += '<h2>' + data[i].title + '';
							html += '<br>';
							html += '<small>' + data[i].time + '</small>';
							html += '</h2>';
							html += '<div class="row" style="padding:15px;"><div class="col-sm-6"><img src='
									+ data[i].img
									+ ' class="imgs img-thumbnail"></div><div class="col-sm-6"><p>'
									+ subd + '</p></div></div>';
							html += '<a  class="btn btn-default btn-lg blog_modal" id="blog_modal" data-toggle="modal" data-target=".bs-example-modal-lg">详细阅读</a>';
							html += '<hr>';
							html += '</div>';

						}
						$(".contenct").append(html);
						page_(data.length, "blog");// 分页函数回调

						modal(data);// 弹窗获取数据回调

					},
					timeout : (10000),
					error : function() {
						alert("您的网络目前不通畅获取失败,请重新刷新。");
					}
				})
	}
}

/*
 * var message={ selects:function(){ $.ajax({ type:"GET", dataType:"json",
 * //jsonp: 'callback', url:"json/message.txt", success: function(data){
 * $(".message").html(""); var html=""; for(var i=0;i<data.length;i++) {
 * html+='<div class="col-lg-12 text-center">'; html+='<h2>'; html+='<small>'+data[i].time+'</small>';
 * html+='</h2>'; html+=''+data[i].contenct+''; html+='<hr>'; html+='</div>'; }
 * $(".message").append(html);
 * 
 * page_(data.length,"message div");//分页函数回调
 * 
 * 
 * <div class="col-lg-12 text-center">
 * 
 * <h2>
 * 
 * <small>October 13, 2013</small> </h2> <p>Lid est laborum dolo rumes fugats
 * untras. Etharums ser quidem rerum facilis dolores nemis omnis fugats vitaes
 * nemo minima rerums unsers sadips amets. Sed ut perspiciatis unde omnis iste
 * natus error sit voluptatem accusantium doloremque laudantium, totam rem
 * aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto
 * beatae vitae dicta sunt explicabo.</p>
 * 
 * <hr> </div>
 *  }, timeout:(10000), error: function(){ alert("您的网络目前不通畅获取失败,请重新刷新。"); } }); } }
 */


	$(".Message_submit").click(function(){

		$.ajax({
			type:"POST",
			url:"AddMessage",
			dataType:"JSON",
			data:{name:$("#name").val(),phone:$("#phone").val(),email:$("#email").val(),message:$("#mess").val()},
			success:function(data){
				if(data)
				{alert("发送成功");}
				else{
					alert("发送失败");
				}

			},
			timeout:(1000),
			error:function(){
				alert("传输异常");
			}
		})
	});