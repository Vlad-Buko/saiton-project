
function getIndex(list,id) {
    for (var i= 0; i < list.length; i++) {
        if (list[i].id === id) {
            return i;
        }
    }
    return -1;
}

var spareAPi = Vue.resource('/autoshop/api/spares/{/id}');

Vue.component('spare-form', {
    props: ['spares', 'spareAttr'],
    data: function () {
        return {
            text: '',
            id: ''
        }
    },
    watch: {
      spareAttr : function(newVal, oldVal) {
          this.text = newVal.text;
          this.id = newVal.id;
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

            if (this.id) {
                spareAPi.update({
                    id: this.id
                }, spare).then(result => result.json().then(data => {
                    var index = getIndex(data.id);
                    this.spare.splice(index, 1, data);
                }))
            } else {
                spareAPi.save({}, spare).then(result =>
                    result.json().then(data => {
                            this.spares.push(data);
                            this.text = ''
                        }
                    ))
            }
        }
    }
})

Vue.component('spare-row', {
    props: ['spare', 'editMethod'],
    template: '<div><i>({{spare.id}})</i> {{spare.text}}' +
        '<span>' +
        '<input type="button" value="Edit" @click="edit" />' +
        '</span>' +
        '</div',
    methods: {
        edit: function () {
            this.editMethod(this.spare );
        }
    }
})

Vue.component('spares-list', {
    props: ['spares'],
    data:function () {
        return {
            spare: null
        }
    },
    template: '<div>' +
        '<spare-form :spares="spares", :spareAttr="spare" />' +
        '<spare-row v-for="spare in spares" :key="spare.id" :spare="spare" :editMethod="editMethod" />' +
                '</div>',
    // В темплейт в цикле v-for также зависит значение "spare in (наше название перерменной)
    created: function () {
        spareAPi.get().then(result =>
            result.json().then(data =>
                data.forEach(spare => this.spares.push(spare))))
    },
    methods: {
        editMethod: function () {
            this.spare = spare;
        }
    }
})

var app = new Vue({
    el: '#app',
    template: '<spares-list :spares="spares" />',
    data: {
        spares : []
    }
});