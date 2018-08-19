$(function() {
	console.log("hello");
	$.get({
		url : '../monthSummary',
		data : null,
		success : success,
		dataType : 'json'
	});
});

function success(data) {
	for ( var key in data) {
		var tr = $('<tr/>');
		$(tr).append($('<td/>').text(data[key]['monthyear']));
		$(tr).append($('<td/>').text(data[key]['count']));
		$('#datarows').append(tr);
	}
	$('#datatable').DataTable({
		"paging" : false
	});
}