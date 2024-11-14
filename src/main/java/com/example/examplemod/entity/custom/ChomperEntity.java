package com.example.examplemod.entity.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class ChomperEntity extends Monster implements IAnimatable {
    // 管理实体的动画控制器
    private AnimationFactory factory = GeckoLibUtil.createFactory(this);
    public ChomperEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    // 设置实体的属性
    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH,4.0D)
                .add(Attributes.ATTACK_DAMAGE, 1.0f)
                .add(Attributes.ATTACK_SPEED,1.0f)
                .add(Attributes.MOVEMENT_SPEED,0.4f).build();
    }

    // 实体的AI
// 数值越小优先级越高
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1,new FloatGoal(this));// 在水中浮动
        this.goalSelector.addGoal(2,new MeleeAttackGoal(this,1.2D,false));// 近战攻击，攻击速度，攻击速度，是否长时间追踪目标
        this.goalSelector.addGoal(4,new WaterAvoidingRandomStrollGoal(this,1.0D));// 在陆地上漫步。
        this.goalSelector.addGoal(5,new RandomLookAroundGoal(this));//随机看向周围

        this.targetSelector.addGoal(2,new NearestAttackableTargetGoal<>(this, Zombie.class,true));// 攻击最近的可攻击目标，玩家，是否检查视线
        this.targetSelector.addGoal(3,new NearestAttackableTargetGoal<>(this, Skeleton.class,false));
        this.targetSelector.addGoal(4,new NearestAttackableTargetGoal<>(this, Creeper.class,true));
        super.registerGoals();
    }
    // 根据动画事件设置控制器
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event){
        if(event.isMoving()){
            event.getController().setAnimation( new AnimationBuilder().addAnimation("walk", ILoopType.EDefaultLoopTypes.LOOP));
            // 继续播放
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", ILoopType.EDefaultLoopTypes.LOOP));
        return PlayState.CONTINUE;

    }
    // 注册控制器
    @Override
    public void registerControllers(AnimationData data) {
        // 实体，名称，频率，函数式接口
        data.addAnimationController(new AnimationController(this, "squirrel",0,this::predicate));
    }
    // 返回动画控制器
    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
    // 走路
    protected void playStepSound(){
        this.playSound(SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES,0.15F,1.0F);
    }
    // 环境
    protected SoundEvent getAmbientSound(){
        return SoundEvents.CAT_STRAY_AMBIENT;
    }
    // 收到攻击
    protected SoundEvent getHurtSound(DamageSource damageSource){
        return SoundEvents.DOLPHIN_HURT;
    }
    // 死亡
    protected SoundEvent getDeathSound(){
        return SoundEvents.DOLPHIN_DEATH;
    }
    // 声音大小
    protected float getSoundVolume(){
        return 0.2F;
    }
}
