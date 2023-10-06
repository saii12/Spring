$(function(){

// User3
				$('#btnUser3s').click(function(){
					
					$.ajax({
						url: '/Ch10/user3',
						type: 'GET',						
						dataType: 'json',
						success: function(data){
							console.log(data);							
						}
						
					});
					
				});
				
				$('#btnUser3').click(function(){
					$.ajax({
						url: '/Ch10/user3/a102',  // 파라미터 이렇게
						type: 'GET',						
						dataType: 'json',
						success: function(data){
							console.log(data);							
						}
						
					});
				});
				
				$('#btnUser3Register').click(function(){
					
					const jsonData = {
						id: 's101',
						name: '홍길동',
						hp: '010-1111-1001',
						age: 22 
					};
					
					$.ajax({
						url: '/Ch10/user3',
						type: 'POST',
						data: jsonData,
						dataType: 'json',
						success: function(data){
							console.log(data);							
						}
						
					});
				});
				
				$('#btnUser3Modify').click(function(){
					const jsonData = {
						id: 's101',
						name: '홍길동',
						hp: '010-2222-1001',
						age: 23
					};
					
					$.ajax({
						url: '/Ch10/user3',
						type: 'PUT', // PUT은 굳이 파라미터를 안 보내는게 jsonData 생성시 id 값이 이미 있으니까 그 위에 덮어쓰기만 하면 되서??
						data: jsonData,
						dataType: 'json',
						success: function(data){
							console.log(data);							
						}
						
					});
				});
				
				$('#btnUser3Delete').click(function(){
					$.ajax({
						url: '/Ch10/user3/s101',
						type: 'DELETE',
						dataType: 'json',
						success: function(data){
							console.log(data);							
						}
						
					});
				});
				
		});