var options = {
	chart: {
		height: 212,
		type: "bar",
		toolbar: {
			show: false,
		},
	},
	plotOptions: {
		bar: {
			columnWidth: "50%",
			borderRadius: 8,
			distributed: true,
			dataLabels: {
				position: "top",
			},
		},
	},
	series: [
		{
			name: "Designation",
			data: [52, 73, 34, 66, 49],
		},
	],
	legend: {
		show: false,
	},
	xaxis: {
		categories: ["Email", "Referral", "Organic", "Direct", "Campaign"],
		axisBorder: {
			show: false,
		},
		yaxis: {
			show: false,
		},

		tooltip: {
			enabled: true,
		},
		labels: {
			show: true,
			rotate: -45,
			rotateAlways: true,
		},
	},
	grid: {
		borderColor: "#b7c6d8",
		strokeDashArray: 5,
		xaxis: {
			lines: {
				show: true,
			},
		},
		yaxis: {
			lines: {
				show: false,
			},
		},
		padding: {
			top: 0,
			right: 10,
			left: 20,
			bottom: -20,
		},
	},
	tooltip: {
		y: {
			formatter: function (val) {
				return val;
			},
		},
	},
	colors: [
		"#7fa9d8",
		"#7fa9d8",
		"#7fa9d8",
		"#7fa9d8",
		"#df8e8e",
		"#28256d",
		"#007600",
	],
};
var chart = new ApexCharts(document.querySelector("#sessions"), options);
chart.render();
