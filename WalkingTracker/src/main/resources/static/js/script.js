window.addEventListener('load', function(e) {
	console.log('script.js is loaded');
	init();
});

function init() {
	document.contestantForm.lookup.addEventListener('click', function(event) {
		event.preventDefault();
		var contestantId = document.contestantForm.contestantId.value;
		if (!isNaN(contestantId) && contestantId > 0) {
			getContestant(contestantId);
		}
	});
	document.contestantForm.delete.addEventListener('click', function(event) {
		event.preventDefault();
		var contestantId = document.contestantForm.contestantId.value;
		if (!isNaN(contestantId) && contestantId > 0) {
			deleteContestant(contestantId);
		}
	});
	
document.addContestantForm.addContestant.addEventListener('click', function(event) {
	event.preventDefault();
	let fm = document.addContestantForm;
	let newContestant = {
		name: fm.name.value,
		gender: fm.gender.value,
		age: fm.age.value,
		representingCity: fm.representingCity.value,
		representingState: fm.representingState.value,
		eventName: fm.eventName.value,
		eventDate: fm.eventDate.value,
		finishTime: fm.finishTime.value,
		place: fm.place.value
	};
	console.log(newContestant);
	postNewContestant(newContestant);
});


function postNewContestant(newContestant) {
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/contestants');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				let contestant = JSON.parse(xhr.responseText);
				displayContestant(contestant);
				console.log('New Runner Added')

			}
			else {
				console.log('Did Not Create New Runner')
				//TODO
				// H1 That Says Runner Not Added. 
			}
		}
	};

	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(JSON.stringify(newContestant));
}


	document.updateForm.updateContestant.addEventListener("click", function(e) {
		e.preventDefault();
		let updatedContestantId = document.contestantForm.contestantId.value;
		updateContestant(updatedContestantId);
	});
}

function updateContestant(contestantId) {
	let fm = document.updateForm;
	let updatedContestant = {
		name: fm.name.value,
		gender: fm.gender.value,
		age: fm.age.value,
		representingCity: fm.representingCity.value,
		representingState: fm.representingState.value,
		eventName: fm.eventName.value,
		eventDate: fm.eventDate.value,
		finishTime: fm.finishTime.value,
		place: fm.place.value,
	};
	let xhr = new XMLHttpRequest();
	xhr.open("PUT", `api/contestants/${contestantId}`);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status == 200 || xhr.status == 201) {
				updatedContestant = JSON.parse(xhr.responseText);
				displayContestant(updatedContestant);
			} else {
				console.error(xhr.status + ": " + xhr.responseText);
			}
		}
	};
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(JSON.stringify(updatedContestant));
	updateForm.reset();
}

function getContestant(contestantId) {
	console.log('getContestant(): ContestantId is ' + contestantId);
	let xhr = new XMLHttpRequest();
	console.log('xhr.readyState = ' + xhr.readyState);
	xhr.open('GET', 'api/contestants/' + contestantId);
	console.log('xhr.readyState = ' + xhr.readyState);
	xhr.onreadystatechange = function() {
		console.log('xhr.readyState = ' + xhr.readyState);

		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let contestant = JSON.parse(xhr.responseText);
				console.log(contestant);
				displayContestant(contestant);
			}
			else {
				// HOW DO I PRINT OUT THIS H1 WHEN I CAN'T FIND AN ID?????????
				var dataDiv = document.getElementById('contestantData');
				dataDiv.textContent = '';
				let h1 = document.createElement('h1');
				h1.textContent = 'Failed To Get Runner With That ID... Try A Different ID.';
				console.log('Failed Getting Runners Id, Make Sure Id is Valid');
			}
		}
	}
	console.log('Before send: xhr.readyState = ' + xhr.readyState);
	xhr.send();
	console.log('After send: xhr.readyState = ' + xhr.readyState);
}



function displayContestant(contestant) {
	var dataDiv = document.getElementById('contestantData');
	dataDiv.textContent = '';
	let h1 = document.createElement('h1');
	h1.textContent = 'Contestant Name: ' + contestant.name;
	dataDiv.appendChild(h1);
	let bq = document.createElement('blockquote');
	bq.textContent = 'Contestant Info: '
	dataDiv.appendChild(bq);
	let ul = document.createElement('ul');
	dataDiv.appendChild(ul);
	let li = document.createElement('li');
	li.textContent = 'Id: ' + contestant.id;
	ul.appendChild(li);
	li = document.createElement('li');
	li.textContent = 'Gender: ' + contestant.gender;
	ul.appendChild(li);
	li = document.createElement('li');
	li.textContent = 'Age: ' + contestant.age;
	ul.appendChild(li);
	li = document.createElement('li');
	li.textContent = 'Representing City of: ' + contestant.representingCity;
	ul.appendChild(li);
	li = document.createElement('li');
	li.textContent = 'Representing State of: ' + contestant.representingState;
	ul.appendChild(li);
	li = document.createElement('li');
	li.textContent = 'Event: ' + contestant.eventName;
	ul.appendChild(li);
	li = document.createElement('li');
	li.textContent = 'Event Date: ' + contestant.eventDate;
	ul.appendChild(li);
	li = document.createElement('li');
	li.textContent = 'Finish Time: ' + contestant.finishTime;
	ul.appendChild(li);
	li = document.createElement('li');
	li.textContent = 'Final Place: ' + contestant.place;
	ul.appendChild(li);
}

function deleteContestant(contestantId) {
	let xhr = new XMLHttpRequest();
	xhr.open('DELETE', 'api/contestants/' + contestantId);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 204) {
				var dataDiv = document.getElementById('contestantData');
				dataDiv.textContent = '';
				let h1 = document.createElement('h1');
				h1.textContent = 'Runner Removed...';
				dataDiv.appendChild(h1);
				console.log('Deleted Runner!');
			}
			else {
				console.log('Failed Deleting Runners Id, Runner may have been deleted...');
			}
		}
	}
	console.log('Before send: xhr.readyState = ' + xhr.readyState);
	xhr.send();
	console.log('After send: xhr.readyState = ' + xhr.readyState);
	document.contestantForm.reset();
}

function postNewContestant(newContestant) {
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/contestants');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				let contestant = JSON.parse(xhr.responseText);
				displayContestant(contestant);
				console.log('New Runner Added')

			}
			else {
				console.log('Did Not Create New Runner')
				//TODO
				// H1 That Says Runner Not Added. 
			}
		}
	};

	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(JSON.stringify(newContestant));
}