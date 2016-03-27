// JavaScript Document


function modal(data){
	$(".blog_modal").click(function(){
		var point=$(".blog_modal").index(this);

		html='';
		html+='<p class="content-title">'+data[point].title+'</p>';
		html+='<p class="content-time">'+data[point].time+'</p>'
		html+='<div class="content-img"><img src="'+data[point].img+'"></div>';
		html+='<div class="content"><p>'+data[point].contenct+'</p></div>';
		$(".state").html(html);
		/*
		     			<p class="content-title">Post Title</p>
                <p class="content-time">October 13, 2013</p>
                <div class="content-img"><img src="img/slide-1.jpg"></div>
                <div class="content">
                <p>Lid est laborum dolo rumes fugats untras. Etharums ser quidem rerum facilis dolores nemis omnis fugats vitaes nemo minima rerums unsers sadips amets. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
                </div>
		*/
		});
	}
	
function modal_pen(data){
	$(".blog_modal").click(function(){
		var point=$(".blog_modal").index(this);
		
		html='';
		html+='<p class="content-title">'+data[point].title+'</p>';
		html+='<p class="content-time">'+data[point].time+'</p>';
		html+='<div class="content-img"><pre class="line-numbers wow "><code class="language-markup">'+data[point].pro+'</code></pre></div>';
		html+='<div class="content">'+data[point].contenct+'</div>';
		$(".state").html(html);		

		/*
		     			<p class="content-title">Post Title</p>
                <p class="content-time">October 13, 2013</p>
                <div class="content-img"><img src="img/slide-1.jpg"></div>
                <div class="content">
                <p>Lid est laborum dolo rumes fugats untras. Etharums ser quidem rerum facilis dolores nemis omnis fugats vitaes nemo minima rerums unsers sadips amets. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
                </div>
		*/
		

		});
	}