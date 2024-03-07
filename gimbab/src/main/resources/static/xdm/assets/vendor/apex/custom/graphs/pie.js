var options = {
	chart: {
		width: 300,
		type: "pie",
	},
	labels: ["Team A", "Team B", "Team C", "Team D", "Team E"],
	series: [20, 20, 20, 20, 20],
	legend: {
		position: "bottom",
	},
	dataLabels: {
		enabled: false,
	},
	stroke: {
		width: 0,
	},
	colors: [
		"#c7c6ec",
		"#a2a0df",
		"#7d7ad2",
		"#5854c5",
		"#3f3aab",
		"#312d85",
		"#ea95bf",
		"#b5d085",
	],
};
var chart = new ApexCharts(document.querySelector("#pie"), options);
chart.render();
