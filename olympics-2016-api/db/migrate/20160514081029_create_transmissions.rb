class CreateTransmissions < ActiveRecord::Migration
  def change
    create_table :transmissions do |t|
      t.string :place
      t.text :description
      t.timestamp :date
      t.string :lat
      t.string :lon

      t.timestamps null: false
    end
  end
end
