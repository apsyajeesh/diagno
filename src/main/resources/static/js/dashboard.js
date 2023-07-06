// JavaScript code to load different content based on navigation clicks

$(document).ready(function() {
  const startDate = document.getElementById('startDate');
  const startDateListener = function(event) {
    const selectedDate = event.target.value;
    loadAppointments(selectedDate);
    startDate.removeEventListener('change', startDateListener);
  };

  startDate.addEventListener('change', startDateListener);
});


function loadResults() {
  // Perform an AJAX request or update the content directly here
  $("#dynamicContent").html("<h3>Results</h3>");
}

function loadAppointments(date) {
    const appointmentsContainer = document.getElementById('appointmentsContainer');
    appointmentsContainer.innerHTML = '';
    const scheduleBtn = document.getElementById('scheduleBtn');
    const selectedAppointmentTimes = document.getElementById('selectedAppointmentTimes');
    const times = ['9:00 AM', '10:00 AM', '11:00 AM', '12:00 PM', '1:00 PM', '2:00 PM', '3:00 PM', '4:00 PM', '5:00 PM'];

    // Create the appointment time cells in a 5x5 format
    for (let i = 0; i < 5; i++) {
      const row = document.createElement('div');
      row.classList.add('row');

      for (let j = 0; j < 5; j++) {
        const timeIndex = i * 5 + j;
        if (timeIndex < times.length) {
          const column = document.createElement('div');
          column.classList.add('col-2', 'appointment-cell');

          const formCheck = document.createElement('div');
          formCheck.classList.add('form-check');

          const input = document.createElement('input');
          input.classList.add('form-check-input');
          input.type = 'radio';
          input.name = 'appointmentTime';
          input.id = `appointmentTime${timeIndex + 1}`;
          input.value = times[timeIndex];

          const label = document.createElement('label');
          label.classList.add('form-check-label');
          label.htmlFor = `appointmentTime${timeIndex + 1}`;
          label.innerHTML = '&nbsp;' + times[timeIndex];

          formCheck.appendChild(input);
          formCheck.appendChild(label);
          column.appendChild(formCheck);
          row.appendChild(column);

          // Add event listener to capture the selected appointment time
          input.addEventListener('change', function() {
            if (input.checked) {
              const selectedTime = input.value;
              const selectedTimeInput = document.getElementById('selectedTimeInput');
            }
          });
        }
      }

      appointmentsContainer.appendChild(row);
    }
}