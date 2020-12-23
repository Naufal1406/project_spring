var tableProvinsi = {
	create: function(){
		$.ajax({
		url : '/provinsi/get-all-provinsi',
		method : 'get',
		contentType : 'application/json',
		success : function(res, status, xhr) {
			data = "";
			$.each(res, function(index, value) {
				data += "<tr>";
				data += "<td>" + value.id + "</td>";
				data += "<td>" + value.namaProvinsi + "</td>";
				data += "<td>" + value.kodeProvinsi + "</td>";
				data += "<tr>";
			});
			$('#body-provinsi').append(data);
			console.log(res)
			},
			
		error : function(e){
			alert(e);
			}
		});
	},
	
	getProvinsi: function(){
			$.ajax({
	            url: '/provinsi/get-all-provinsi',
	            type : 'get',
	            contentType: 'application/json',
	            success: function(res, status, xhr) {
	                if (xhr.status == 200 || xhr.status == 201) {
	                    $('#table-provinsi').DataTable({
	                        data: res,
	                        columns: [{
	                            title: "id",
	                            data: "id"
	                        }, {
	                            title: "Nama Provinsi",
	                            data: "namaProvinsi"
	                        }, {
	                            title: "Kode Provinsi",
	                            data: "kodeProvinsi"
	                        }, {
		 						title: "Action",
	                            data: null,
	                            render: function(data, type, row) {
	                                console.log(data)
	                                return "<button class='btn-primary' onclick=formProvinsi.setEditData('" + data.id + "')>Edit</button>"
									+ " " + "<button class='btn-danger' onclick=formProvinsi.delete('"+ data.id +"')>Delete</button>"
	                            }
	                        }]
	                    });
	
	                } else {}
	            },
	            error: function(err) {
	                console.log(err);
	            }
	        });
		}
}

var formProvinsi = {
	save : function(){
		var provinsi = {}
		provinsi["namaProvinsi"] = $('#namaProvinsi').val();
		provinsi["kodeProvinsi"] = $('#kodeProvinsi').val();
	
		$.ajax({
			method : 'post',
			url :'/provinsi/post-provinsi',
			contentType: 'application/json',
			data : JSON.stringify(provinsi),
			success : function(res) {
				console.log(res)
			}
		})
	},
	
		setEditData: function(id) {
			$.ajax({
				method:'get',
				url:'/provinsi/get-provinsiById/' + id,
				contentType : 'application/json',
				type : 'json',
				success: function(res) {
					console.log(res)
					$('#id').val(res.id)
					$('#namaProvinsi').val(res.namaProvinsi)
					$('#kodeProvinsi').val(res.kodeProvinsi)
					
					$('#btn-save').off('click').on('click', function() {
						formProvinsi.update(res.id);
						tableProvinsi.getProvinsi;
							$('#btn-save').off('click').on('click' , function() {
								formProvinsi.save();
							})
					})
					
			}
		})
	},
	
		update: function(id) {
			var provinsi = {}
			provinsi["id"] = $('#id').val();
			provinsi["namaProvinsi"] = $('#namaProvinsi').val();
			provinsi["kodeProvinsi"] = $('#kodeProvinsi').val();
			
			$.ajax({
				method: 'put',
				url: '/provinsi/update-provinsi/' + id,
				contentType : 'application/json',
				data : JSON.stringify(provinsi),
				success : function(res) {
					console.log(res)
				}
				
			})
	},
	
		delete: function(id) {
			$.ajax({
				method: 'delete',
				url: '/provinsi/delete-provinsi/' + id,
				contentType : '/application/json',
				success : function(res) {
					console.log(res)
				}				
			})
		}
}
