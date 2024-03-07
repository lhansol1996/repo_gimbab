var options = {
	chart: {
		height: 231,
		type: "radialBar",
		toolbar: {
			show: false,
		},
	},
	plotOptions: {
		radialBar: {
			dataLabels: {
				name: {
					fontSize: "12px",
					fontColor: "black",
				},
				value: {
					fontSize: "21px",
				},
				total: {
					show: true,
					label: "Total",
					formatter: function (w) {
						// By default this function returns the average of all series. The below is just an example to show the use of custom formatter function
						return "250";
					},
				},
			},
			track: {
				background: "#e6ecf3",
			},
		},
	},
	series: [80, 70, 10],
	labels: ["Desktop", "Tablet", "Mobile"],
	colors: ["#9492c7", "#4a4694", "#28256d"],
};

var chart = new ApexCharts(document.querySelector("#device-sessions"), options);
chart.render();
