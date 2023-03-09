
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
            name: '',
            id: ''
        }
    },
    watch: {
      spareAttr : function(newVal, oldVal) {
          this.name = newVal.name;
          this.id = newVal.id;
      }
    },
    template:
        '<div>' +
            '<input type="text" placeholder="Write something!!! " v-model="name" />' +
            '<input type="button" value="Save" @click="save"  />' +
        '</div>' ,
    methods: {
        save: function () {
            var spare = {name: this.name};

            if (this.id) {
                spareAPi.update({
                    id: this.id
                }, spare).then(result => result.json().then(data => {
                    var index = getIndex(this.spares, data.id);
                    this.spares.splice(index, 1, data);
                    this.name = '';
                    this.id = '';
                }))
            } else {
                spareAPi.save({}, spare).then(result =>
                    result.json().then(data => {
                            this.spares.push(data);
                            this.name = ''
                        }
                    ))
            }
        }
    }
})

Vue.component('spare-row', {
    props: ['spare', 'editMethod', 'spares'],
    template: '<div><i>({{spare.id}})</i> {{spare.name}}' +
        '<span style="position: absolute; right: 0">' +
        '<input type="button" value="Edit" @click="edit" />' +
        '<input type="button" value="X" @click="del" />' +
        '</span>' +
        '</div>',
    methods: {
        edit: function () {
            this.editMethod(this.spare);
        },
        del: function () {
            spareAPi.remove({id: this.spare.id}).then(result => {
                if (result.ok) {
                    this.spares.splice(this.spares.indexOf(this.spare), 1 )
                }
            })
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
    template: '<div style="position: relative; width: 300px;">' +
        '<spare-form :spares="spares" :spareAttr="spare" />' +
        '<spare-row v-for="spare in spares" :key="spare.id" :spare="spare" ' +
        ':editMethod="editMethod" :spares="spares" />' +
                '</div>',
    // В темплейт в цикле v-for также зависит значение "spare in (наше название перерменной)
    created: function () {
        spareAPi.get().then(result =>
            result.json().then(data =>
                data.forEach(spare => this.spares.push(spare))))
    },
    methods: {
        editMethod: function (spare) {
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