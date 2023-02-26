var spareAPi = Vue.resource('/autoshop/api/spares/{/id}');

Vue.component('spare-form', {
    props: ['spares'],
    data: function () {
        return {
            text: ''
        }
    },
    template:
        '<div>' +
            '<input type="text" placeholder="Write something!!! " v-model="text" />' +
            '<input type="button" value="Save" @click="save"  />' +
        '</div>' ,
    methods: {
        save: function () {
            var spare = {text: this.text};

            spareAPi.save({}, spare).then(result =>
                result.json().then(data => {
                    this.spares.push(data);
                    this.text = ''
                    }
                ))
        }
    }
})

Vue.component('spare-row', {
    props: ['spare1'],
    template: '<div><i>({{spare1.id}})</i> {{spare1.text}}</div>'
})

Vue.component('spares-list', {
    props: ['spares'],
    template: '<div>' +
        '<spare-form :spares="spares" />' +
        '<spare-row v-for="spare in spares" :key="spare.id" :spare1="spare" />' +
                '</div>',
    // В темплейт в цикле v-for также зависит значение "spare in (наше название перерменной)
    created: function () {
        spareAPi.get().then(result =>
            result.json().then(data =>
                data.forEach(spare1 => this.spares.push(spare1))))
    }
})

var app = new Vue({
    el: '#app',
    template: '<spares-list :spares="spares" />',
    data: {
        spares : []
    }
});