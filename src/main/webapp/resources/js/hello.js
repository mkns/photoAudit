$(function() {
	console.log("hello");
	$.get({
		url : '../heyJson',
		data : null,
		success : success,
		dataType : 'json'
	});
});

function success(data) {
	console.log(data);
	console.log(JSON.stringify(data));
	for ( var key in data) {
		console.log("Key is " + key + " and value is " + data[key]);
	}
	$("#foo").text(data['foo']);
}