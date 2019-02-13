app.controller('AfterLoginController', function($scope) {
    //
   });
   
   app.controller('AfterHomeController', function($scope) {
    //
   });
   
   app.controller('AfterPageController', function($scope) {
    //
   });
   
   app.controller('CalendarCtrl', ['$scope', 'moment', 'calendarConfig', '$ionicScrollDelegate', 'PlantaoAPIService', '$ionicModal', function($scope, moment, calendarConfig, $ionicScrollDelegate, PlantaoAPIService, $ionicModal) {
         calendarConfig.dateFormatter = 'moment';
         var vm = this;
     
         //These variables MUST be set as a minimum for the calendar to work
         vm.calendarView = 'month';
         vm.viewDate = new Date();
         console.log(vm.calendarView);
         var actions = [{
           label: '<i class=\'glyphicon glyphicon-pencil\'></i>',
           onClick: function(args) {
             alert.show('Edited', args.calendarEvent);
           }
         }, {
           label: '<i class=\'glyphicon glyphicon-remove\'></i>',
           onClick: function(args) {
             alert.show('Deleted', args.calendarEvent);
           }
         }];
         
         vm.showAlert = function() {
           console.log("Alert!")
         }
         
         
         
      // MODEL Calendário GLOBAL, Todos os Plantões:
      vm.plantoes = [];
      vm.plantoes = PlantaoAPIService.getData();
      
      // MODEL Plantões do médicos exibidos no calendário:
        var medicoId = 2; // ID do médico que fez a sessão no app;
        vm.events = vm.plantoes.filter( plantao => plantao.medicoId == medicoId );
        console.log(vm.events);
        
        
        vm.medicos = vm.plantoes.filter( plantao => plantao.medicoId !== medicoId );

         vm.cellIsOpen = true;
     
         vm.addEvent = function() {
           vm.events.push({
             title: 'New event',
             startsAt: moment().startOf('day').toDate(),
             endsAt: moment().endOf('day').toDate(),
             color: calendarConfig.colorTypes.important,
             draggable: true,
             resizable: true
           });
         };
         
         $ionicModal.fromTemplateUrl('views/logged/modal_plantao.html', {
           scope: $scope,
           animation: 'slide-in-up'
         }).then(function(modal) {
           $scope.modal = modal;
         });
   
    
         vm.eventClicked = function(event) {
           vm.currentEvent = event;
           
           let convertDate = {
             inicio: new Date(vm.currentEvent.startsAt),
             final: new Date(vm.currentEvent.endsAt),
           };
           
           vm.currentEvent.convertDates  = {
             inicio: moment(convertDate.inicio).format('DD/MM/YYYY'),
             final: moment(convertDate.final).format('DD/MM/YYYY')
           };
 
           $ionicScrollDelegate.scrollTop();
           angular.element('#plantaoModal').css('display', 'block');
         };
         
         vm.closePlantaoModal = function(){
            angular.element('#plantaoModal').fadeOut();
         }
         
         // FUNCOES PAR MODAL MEDICOS
         vm.selectedMedic = 'Selecione um médico'
         
         vm.openModalMedicos = function() {
           angular.element('#medicosNomeModal').css('display', 'block');
         }
         
         vm.closeModalMedicos = function(){
            angular.element('#medicosNomeModal').fadeOut();
         }
         
         vm.chooseMedic = function(item) {
         
           vm.selectedMedic = item;
           
            var convertDate = {
              inicio: new Date(vm.selectedMedic.startsAt)
            };
             vm.selectedMedic.startsAt = moment(convertDate.inicio).format('DD/MM/YYYY');

           
           //console.log(choosen[0].medico)
           vm.closeModalMedicos()
         }
     
         vm.toggle = function($event, field, event) {
           $event.preventDefault();
           $event.stopPropagation();
           event[field] = !event[field];
         };
     
         vm.timespanClicked = function(date, cell) {
     
           if (vm.calendarView === 'month') {
             if ((vm.cellIsOpen && moment(date).startOf('day').isSame(moment(vm.viewDate).startOf('day'))) || cell.events.length === 0 || !cell.inMonth) {
               vm.cellIsOpen = false;
             } else {
               vm.cellIsOpen = true;
               vm.viewDate = date;
             }
           } else if (vm.calendarView === 'year') {
             if ((vm.cellIsOpen && moment(date).startOf('month').isSame(moment(vm.viewDate).startOf('month'))) || cell.events.length === 0) {
               vm.cellIsOpen = false;
             } else {
               vm.cellIsOpen = true;
               vm.viewDate = date;
             }
           }
         };
       }]);
       
     // app.factory('alert', function($modal) {
   
     //   function show(action, event) {
     //     return $modal.open({
     //       templateUrl: './modalContent.html',
     //       controller: function() {
     //         var vm = this;
     //         vm.action = action;
     //         vm.event = event;
     //         vm.medico = "Dr. Pablo Mendes"
     //       },
     //       controllerAs: 'vm'
     //     });
     //   }
   
     //   return {
     //     show: show
     //   };
   
     // });
      