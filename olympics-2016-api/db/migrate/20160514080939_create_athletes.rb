class CreateAthletes < ActiveRecord::Migration
  def change
    create_table :athletes do |t|
      t.string :name
      t.text :bio
      t.integer :age
      t.references :moladity, index: true, foreign_key: true

      t.timestamps null: false
    end
  end
end
