const app = Vue.createApp({
    data(){
        return{
            data: [],
            url: "http://localhost:8080/api/clientcurrent",
            email:"",
            password:"",
            name:"",
        }
    },
    created(){
        this.loadData(this.url);
    },
    methods:{

        loadData(url){
            axios.get(url)
            .then((response) =>{
                this.data = response.data;
                console.log(this.data);
                this.name = this.data.name;
            })
        },
         

    }
}).mount('#app');