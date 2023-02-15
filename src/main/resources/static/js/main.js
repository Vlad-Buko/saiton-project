// Определяем новый компонент под именем todo-item
Vue.component('list-city', {
    props: ['message'],
    template: '<div><i>{{message.id}}</i> {{messages.text}} </div>'
})

Vue.component('spares-list', {
    props: ['messages'],
    template: '<div><list-city v-for="message in messages " :key="message.id" :message="message" /></div>'
})

var app = new Vue({
    el: '#app',

    template: '<spares-list :messages="messages"/>',
    data: {
        messages: [
            {id: '12', text: 'Hell'},
            {id: '211', text: 'Minsk'},
            {id: '21', text: 'Vitebsk'},
        ]
    }
})