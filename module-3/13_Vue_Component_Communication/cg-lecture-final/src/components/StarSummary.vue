<template>


    <div class="well">
        
        <span class="amount">{{ numOfReviews }}</span>
        {{rating}} Star Review{{ numOfReviews === 1 ? '' : 's' }}
    </div>

 
</template>

<script>
export default {
    name: "star-summary",
    props: ['numOfReviews', 'rating']
}
</script>

<style>

</style>