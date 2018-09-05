$(function() {
	console.log("hello");
	$.get({
		url : 'monthSummaryController',
		data : null,
		success : success,
		dataType : 'json'
	});
});

function success(data) {
	for ( var key in data) {
		console.log(key);
		console.log(data[key]['monthyear']);
		var tr = $('<tr/>');
		$(tr).append($('<td/>').text(data[key]['monthyear']));
		$(tr).append($('<td/>').text(data[key]['count']));
		$('#datarows').append(tr);
	}
	$('#datatable').DataTable({
		"paging" : false
	});
}