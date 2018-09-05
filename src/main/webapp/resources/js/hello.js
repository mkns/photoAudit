$(function() {
	console.log("hello");
	$.get({
		url : 'heyJson',
		data : null,
		success : success,
		dataType : 'json'
	});
});

function success(data) {
	for ( var key in data) {
		var tr = $('<tr/>');
		$(tr).append($('<td/>').text(data[key]['file']));
		$(tr).append($('<td/>').text(data[key]['filesize']));
		$(tr).append($('<td/>').text(data[key]['name']));
		$(tr).append($('<td/>').text(data[key]['thumbnail']));
		$(tr).append($('<td/>').text(data[key]['path']));
		$(tr).append($('<td/>').text(data[key]['monthyear']));
		$(tr).append($('<td/>').text(data[key]['year']));
		$('#datarows').append(tr);
	}
	$('#datatable').DataTable({
		"paging" : false
	});
}